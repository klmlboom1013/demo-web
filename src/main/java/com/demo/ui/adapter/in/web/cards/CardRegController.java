package com.demo.ui.adapter.in.web.cards;

import com.demo.events.application.port.in.jnoffctrns.RecodeJnoffcTrnsEventPublisher;
import com.demo.events.application.port.in.mpibasicinfo.GetMpiBasicInfoEventPublisher;
import com.demo.events.application.port.in.wtid.GetWtidEventPublisher;
import com.demo.ui.adapter.in.web.ModelViewForm;
import com.demo.ui.application.port.in.cards.CreditCardRegCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.ApplicationEventPublisher;
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

    private final ApplicationEventPublisher publisher;

    @GetMapping("ui/{version}/card-reg")
    public String creditCardRegRun(@PathVariable String version, CreditCardRegCommand command, Model model) {
        command.setVersion(version);
        /* wtid 생성. */
        GetWtidEventPublisher getWtidEventPublisher = GetWtidEventPublisher.builder()
                .currentDate("20231231")
                .idcDvdCd("LO")
                .build();
        this.publisher.publishEvent(getWtidEventPublisher);
        log.info("event result getWtid: {}", getWtidEventPublisher.getWtid());
        command.setWtid(getWtidEventPublisher.getWtid());
        /* 기준정보 조회. */
        GetMpiBasicInfoEventPublisher getMpiBasicInfoEventPublisher = GetMpiBasicInfoEventPublisher.builder()
                .mid(command.getMid())
                .wtid(command.getWtid())
                .searchType("")
                .build();
        this.publisher.publishEvent(getMpiBasicInfoEventPublisher);
        log.info("event result mpiBasicInfo: {}", getMpiBasicInfoEventPublisher.getMpiBasicInfo());
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
