package com.demo.ui.adapter.in.web.billings;


import com.demo.ui.application.port.in.main.BillingSignupCommand;
import com.demo.ui.application.port.in.main.MainUseCasePort;
import com.demo.ui.application.port.in.wtid.GetWtidQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
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

    private final GetWtidQuery query;
    private final MainUseCasePort useCase;

    @GetMapping("ui/{version}/billing-signup")
    public String billingSignupRun(@PathVariable String version, BillingSignupCommand command, Model model) {
        command.setVersion(version);

        /* wtid 생성. */
        this.query.getWtid(command);
        
        /* 모델 세팅 */
        final BillingSignupForm billingSignupForm = BillingSignupForm.builder()
                .wtid(command.getWtid())
                .mid(command.getMid())
                .pinFlagYn(Strings.isNotBlank(command.getPinFlag()) ? command.getPinFlag() : "N")
                .build();

        /* 접속 토큰 생성 */
        billingSignupForm.setAcctkn("data1", "data2", "data3");

        /* 기준정보 조회. */
        billingSignupForm.setBasicInfoData(useCase.execute(command));

        log.info(billingSignupForm.toString());

        /* 데이터 세팅 */
        model.addAttribute("form", billingSignupForm);
        model.addAttribute("useFdsYn", "Y");
        model.addAttribute("useKeyPadYn", "Y");


        return "contents/billing-signup";
    }
}
