package com.demo.ui.adapter.in.web.cards;

import com.demo.ui.application.port.in.main.MainUseCasePort;
import com.demo.ui.application.port.in.wtid.GetWtidQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 신용카드 등록 웹페이지 시작
 * <pre>
 *     - OCR 스캔 패이지
 *     - 카드정보 수기 입력 페이지
 *     - INI BillKey 정보 이용 wpay 카드 등록.
 * </pre>
 */
@Controller
@RequiredArgsConstructor
public class CreditCardRegController {
    private final GetWtidQuery getWtidQuery;
    private final MainUseCasePort useCase;

    @GetMapping("ui/{version}/creditcard-reg")
    public String creditCardRegRun(@PathVariable String version, Model model) {
        model.addAttribute("useFdsYn", "Y");
        model.addAttribute("useKeyPadYn", "Y");
        model.addAttribute("chngBillKeyYn", "N");
        return "contents/creditcard-reg";
    }
}
