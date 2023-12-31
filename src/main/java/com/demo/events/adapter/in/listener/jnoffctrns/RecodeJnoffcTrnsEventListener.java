package com.demo.events.adapter.in.listener.jnoffctrns;

import com.demo.events.application.port.in.jnoffctrns.RecodeJnoffcTrnsEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class RecodeJnoffcTrnsEventListener {

    @EventListener
    public void recodeJnoffcTrnsRun(RecodeJnoffcTrnsEventPublisher recodeJnoffcTrnsEventPublisher) {
       log.info("가맹점 요청 정보 저장: {}", recodeJnoffcTrnsEventPublisher);
    }
}
