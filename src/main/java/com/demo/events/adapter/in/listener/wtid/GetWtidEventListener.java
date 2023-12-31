package com.demo.events.adapter.in.listener.wtid;

import com.demo.events.application.port.in.wtid.GetWtidEventPublisher;
import com.demo.events.application.port.in.wtid.GetWtidQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetWtidEventListener {

    private final GetWtidQuery getWtidQuery;

    @EventListener
    public void getWtid (GetWtidEventPublisher getWtidEventPublisher) {
        this.getWtidQuery.getWtid(getWtidEventPublisher);
    }

}
