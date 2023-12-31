package com.demo.events.adapter.in.listener.wtid;

import com.demo.events.application.port.in.wtid.GetWtidCommand;
import com.demo.events.application.port.in.wtid.GetWtidQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class GetWtidEventListener {

    private final GetWtidQuery getWtidQuery;

    @EventListener
    public void getWtid (GetWtidEventPublisher getWtidEventPublisher) {
        final String wtid = this.getWtidQuery.getWtid(GetWtidCommand.builder()
                        .currentDate(getWtidEventPublisher.getCurrentDate())
                        .idcDvdCd(getWtidEventPublisher.getIdcDvdCd())
                        .build());
        log.info("create wtid success! [{}]", wtid);
        getWtidEventPublisher.setResult(GetWtidEventPublisher.Result.builder()
                        .wtid(wtid).build());
    }
}
