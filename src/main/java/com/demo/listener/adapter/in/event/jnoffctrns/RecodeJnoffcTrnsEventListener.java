package com.demo.listener.adapter.in.event.jnoffctrns;

import com.demo.listener.application.port.in.jnoffctrns.RecodeJnoffcTrnsCommand;
import com.demo.listener.application.port.in.jnoffctrns.RecodeJnoffcTrnsUseCasePort;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class RecodeJnoffcTrnsEventListener {

    private final RecodeJnoffcTrnsUseCasePort recodeJnoffcTrnsUseCasePort;

    @EventListener
    public void recodeJnoffcTrnsRun(RecodeJnoffcTrnsEventPublisher recodeJnoffcTrnsEventPublisher) {
        RecodeJnoffcTrnsCommand recodeJnoffcTrnsCommand = RecodeJnoffcTrnsCommand.builder()
                .mid(recodeJnoffcTrnsEventPublisher.getMid())
                .wtid(recodeJnoffcTrnsEventPublisher.getWtid())
                .requestJsonStr(recodeJnoffcTrnsEventPublisher.getRequestJsonStr())
                .build();
        log.info("가맹점 요청 정보 저장: {}", recodeJnoffcTrnsCommand);

        recodeJnoffcTrnsEventPublisher.setResult(RecodeJnoffcTrnsEventPublisher.Result.builder()
                .data(recodeJnoffcTrnsUseCasePort.execute(recodeJnoffcTrnsCommand))
                .build());
    }
}
