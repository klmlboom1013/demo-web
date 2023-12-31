package com.demo.adapter.in.web.ui.cards;

import com.demo.adapter.in.web.ui.ModelViewForm;
import com.demo.application.port.in.ui.CreditCardRegCommand;
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
 * 신용카드 등록 웹페이지 시작
 * <pre>
 *     - OCR 스캔 패이지
 *     - 카드정보 수기 입력 페이지
 *     - INI BillKey 정보 이용 wpay 카드 등록.
 * </pre>
 */
@Log4j2
@Controller
@RequiredArgsConstructor
public class CardRegController {
    private final GetWtidQuery query;
    private final MpiBasicInfoUseCasePort useCase;

    @GetMapping("ui/{version}/card-reg")
    public String creditCardRegRun(@PathVariable String version, CreditCardRegCommand command, Model model) {
        command.setVersion(version);
        /* wtid 생성. */
        this.query.getWtid(command);
        /* 기준정보 조회. */
        useCase.execute(command);
        /* 데이터 세팅 */
        final ModelViewForm form = ModelViewForm.builder()
                .wtid(command.getWtid())
                .mid(command.getMid())
                .useKeyPadYn("Y")
                .data(CardRegForm.builder()
                        .billKeyChngYn(Strings.isBlank(command.getBillKey()) ? "N" : "Y")
                        .build())
                .build();
        log.info(form.toString());

        /* 모델 세팅 */
        model.addAttribute("form", form);
        return "contents/creditcard-reg";
    }
}
