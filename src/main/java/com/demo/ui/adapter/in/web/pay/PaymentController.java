package com.demo.ui.adapter.in.web.pay;

import com.demo.events.application.port.in.jnoffctrns.RecodeJnoffcTrnsEventPublisher;
import com.demo.events.application.port.in.mpibasicinfo.GetMpiBasicInfoEventPublisher;
import com.demo.events.application.port.in.wtid.GetWtidEventPublisher;
import com.demo.ui.adapter.in.web.ModelViewForm;
import com.demo.ui.application.port.in.pay.PaymentCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 결제요청 웹페이지 시작
 * <pre>
 *     - 결제인증 + 결제승인 1trns 처리.
 *     - 결제 처리 결과 ReturnUrl redirect 전 notice 전송.
 * </pre>
 */
@Log4j2
@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final ApplicationEventPublisher publisher;

    @GetMapping("ui/{version}/payment")
    public String paymentRun(@PathVariable String version, PaymentCommand command, Model model) {
        command.setVersion(version);
        /* wtid 생성. */
        GetWtidEventPublisher getWtidEventPublisher = GetWtidEventPublisher.builder()
                .currentDate("20231231")
                .idcDvdCd("LO")
                .build();
        this.publisher.publishEvent(getWtidEventPublisher);
        log.info("event result getWtid: {}", getWtidEventPublisher.getWtid());
        command.setWtid(getWtidEventPublisher.getWtid());
        /* 기준정보 조회. */
        GetMpiBasicInfoEventPublisher getMpiBasicInfoEventPublisher = GetMpiBasicInfoEventPublisher.builder()
                .mid(command.getMid())
                .wtid(command.getWtid())
                .searchType("")
                .build();
        this.publisher.publishEvent(getMpiBasicInfoEventPublisher);
        log.info("event result mpiBasicInfo: {}", getMpiBasicInfoEventPublisher.getMpiBasicInfo());
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
                .useKeyPadYn(Strings.isNotBlank(command.getPinFlag()) ? command.getPinFlag() : "Y")
                .build();
        log.info(form.toString());
        /* 모델 세팅 */
        model.addAttribute("form", form);
        return "contents/pay-auth";
    }
}
