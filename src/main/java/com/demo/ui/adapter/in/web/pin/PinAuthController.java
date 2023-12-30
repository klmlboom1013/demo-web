package com.demo.ui.adapter.in.web.pin;

import com.demo.ui.application.port.in.main.MainUseCasePort;
import com.demo.ui.application.port.in.wtid.GetWtidQuery;
import lombok.RequiredArgsConstructor;
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
@Controller
@RequiredArgsConstructor
public class PinAuthController {
    private final GetWtidQuery getWtidQuery;
    private final MainUseCasePort useCase;

    @GetMapping("ui/{version}/pin-auth")
    public String pinAuthRun(@PathVariable String version, Model model) {
        model.addAttribute("useFdsYn", "N");
        model.addAttribute("useKeyPadYn", "Y");
        return "contents/pin-auth";
    }
}
