package com.demo.ui.adapter.in.web.billings;

import com.demo.events.adapter.in.listener.jnoffctrns.RecodeJnoffcTrnsEventPublisher;
import com.demo.events.adapter.in.listener.mpibasicinfo.GetMpiBasicInfoEventPublisher;
import com.demo.events.adapter.in.listener.wtid.GetWtidEventPublisher;
import com.demo.ui.adapter.in.web.ModelViewForm;
import com.demo.ui.application.port.in.billings.BillingSignupCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 정기결제 신청 웹페이지 시작
 */
@Log4j2
@Controller
@RequiredArgsConstructor
public class BillingSignupController {

    private final ApplicationEventPublisher publisher;

    @GetMapping("ui/{version}/billing-signup")
    public String billingSignupRun(@PathVariable String version, BillingSignupCommand command, Model model) {
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
        return "contents/billing-signup";
    }
}
