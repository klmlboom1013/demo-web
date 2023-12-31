package com.demo.adapter.in.web.ui.pay;

import com.demo.adapter.in.web.ui.ModelViewForm;
import com.demo.application.port.in.ui.PaymentCommand;
import com.demo.application.port.in.MpiBasicInfoUseCasePort;
import com.demo.application.port.in.GetWtidQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
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
    private final GetWtidQuery query;
    private final MpiBasicInfoUseCasePort useCase;

    @GetMapping("ui/{version}/payment")
    public String paymentRun(@PathVariable String version, PaymentCommand command, Model model) {
        command.setVersion(version);
        /* wtid 생성. */
        this.query.getWtid(command);
        /* 기준정보 조회. */
        useCase.execute(command);
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
