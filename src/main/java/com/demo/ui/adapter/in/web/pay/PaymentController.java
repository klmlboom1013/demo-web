package com.demo.ui.adapter.in.web.pay;

import com.demo.ui.application.port.in.main.MainUseCasePort;
import com.demo.ui.application.port.in.wtid.GetWtidQuery;
import lombok.RequiredArgsConstructor;
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
@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final GetWtidQuery getWtidQuery;
    private final MainUseCasePort useCase;

    @GetMapping("ui/{version}/payment")
    public String paymentRun(@PathVariable String version, Model model) {
        model.addAttribute("form", PaymentForm.builder().build());
        model.addAttribute("useFdsYn", "Y");
        model.addAttribute("useKeyPadYn", "Y");
        return "contents/payment";
    }
}
