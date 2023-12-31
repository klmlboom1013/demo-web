package com.demo.ui.adapter.in.web.pin;

import com.demo.listener.adapter.in.event.jnoffctrns.RecodeJnoffcTrnsEventPublisher;
import com.demo.listener.adapter.in.event.mpibasicinfo.GetMpiBasicInfoEventPublisher;
import com.demo.listener.adapter.in.event.wtid.GetWtidEventPublisher;
import com.demo.ui.adapter.in.web.ModelViewForm;
import com.demo.ui.application.port.in.pin.PinAuthCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 결제 핀번호 인증 웹페이지 시작
 * <pre>
 *     결제 진행과 무관한 단순 핀번호 인증으로 본인 확인 시 사용.
 * </pre>
 */

@Log4j2
@Controller
@RequiredArgsConstructor
public class PinAuthUiController {

    private final ApplicationEventPublisher publisher;

    @GetMapping("ui/{version}/pin-auth")
    public String pinAuthRun(@PathVariable String version, PinAuthCommand command, Model model) {
        command.setVersion(version);
        /* wtid 생성. */
        GetWtidEventPublisher getWtidEventPublisher = GetWtidEventPublisher.builder()
                .currentDate("20231231")
                .idcDvdCd("LO")
                .build();
        this.publisher.publishEvent(getWtidEventPublisher);
        final String wtid = getWtidEventPublisher.getResult().getWtid();
        log.info("event result getWtid: {}", wtid);
        command.setWtid(wtid);
        /* 기준정보 조회. */
        GetMpiBasicInfoEventPublisher getMpiBasicInfoEventPublisher = GetMpiBasicInfoEventPublisher.builder()
                .mid(command.getMid())
                .wtid(command.getWtid())
                .searchType("")
                .build();
        this.publisher.publishEvent(getMpiBasicInfoEventPublisher);
        log.info("event result mpiBasicInfo: {}", getMpiBasicInfoEventPublisher.getResult().getMpiBasicInfo());
        /* 가맹점 요청 데이터 저장 */
        RecodeJnoffcTrnsEventPublisher recodeJnoffcTrnsEventPublisher = RecodeJnoffcTrnsEventPublisher.builder()
                .mid(command.getMid())
                .wtid(command.getWtid())
                .requestJsonStr("....")
                .build();
        this.publisher.publishEvent(recodeJnoffcTrnsEventPublisher);

        /* 데이터 세팅 */
        final ModelViewForm form = ModelViewForm.builder()
                .wtid(command.getWtid())
                .mid(command.getMid())
                .build();
        log.info(form.toString());
        /* 모델 세팅 */
        model.addAttribute("form", form);
        return "contents/pin-auth";
    }
}
