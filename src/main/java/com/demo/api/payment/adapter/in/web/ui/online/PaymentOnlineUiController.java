package com.demo.api.payment.adapter.in.web.ui.online;

import com.demo.api.payment.application.port.in.ui.online.PaymentOnlineCommand;
import com.demo.listener.adapter.in.event.jnoffctrns.RecodeJnoffcTrnsEventPublisher;
import com.demo.listener.adapter.in.event.mpibasicinfo.GetMpiBasicInfoEventPublisher;
import com.demo.listener.adapter.in.event.wtid.GetWtidEventPublisher;
import com.demo.global.dto.viewform.ModelViewForm;
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
public class PaymentOnlineUiController {

    private final ApplicationEventPublisher publisher;

    @GetMapping("ui/{version}/payment/online")
    public String paymentRun(@PathVariable String version, PaymentOnlineCommand command, Model model) {
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
                .useKeyPadYn(Strings.isNotBlank(command.getPinFlag()) ? command.getPinFlag() : "Y")
                .build();
        log.info(form.toString());
        /* 모델 세팅 */
        model.addAttribute("form", form);
        return "contents/pay-auth";
    }
}
