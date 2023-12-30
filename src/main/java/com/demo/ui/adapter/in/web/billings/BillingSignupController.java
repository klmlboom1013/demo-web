package com.demo.ui.adapter.in.web.billings;


import com.demo.ui.adapter.in.web.ModelViewForm;
import com.demo.ui.application.port.in.BillingSignupCommand;
import com.demo.ui.application.port.in.mpibasicinfo.MpiBasicInfoUseCasePort;
import com.demo.ui.application.port.in.wtid.GetWtidQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
    private final MpiBasicInfoUseCasePort useCase;

    @GetMapping("ui/{version}/billing-signup")
    public String billingSignupRun(@PathVariable String version, BillingSignupCommand command, Model model) {
        command.setVersion(version);
        /* wtid 생성. */
        this.query.getWtid(command);
        /* 기준정보 조회. */
        useCase.execute(command);
        /* 데이터 세팅 */
        final ModelViewForm form = ModelViewForm.builder()
                .wtid(command.getWtid())
                .mid(command.getMid())
                .useFdsYn("Y")
                .useKeyPadYn("Y")
                .build();
        log.info(form.toString());
        /* 모델 세팅 */
        model.addAttribute("form", form);
        return "contents/billing-signup";
    }
}
