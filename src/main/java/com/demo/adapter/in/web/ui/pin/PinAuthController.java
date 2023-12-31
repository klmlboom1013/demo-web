package com.demo.adapter.in.web.ui.pin;

import com.demo.adapter.in.web.ui.ModelViewForm;
import com.demo.application.port.in.ui.PinAuthCommand;
import com.demo.application.port.in.MpiBasicInfoUseCasePort;
import com.demo.application.port.in.GetWtidQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
public class PinAuthController {
    private final GetWtidQuery query;
    private final MpiBasicInfoUseCasePort useCase;

    @GetMapping("ui/{version}/pin-auth")
    public String pinAuthRun(@PathVariable String version, PinAuthCommand command, Model model) {
        command.setVersion(version);
        /* wtid 생성. */
        this.query.getWtid(command);
        /* 기준정보 조회. */
        useCase.execute(command);
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