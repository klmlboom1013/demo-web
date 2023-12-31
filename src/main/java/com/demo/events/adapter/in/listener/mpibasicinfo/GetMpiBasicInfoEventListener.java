package com.demo.events.adapter.in.listener.mpibasicinfo;

import com.demo.events.application.port.in.mpibasicinfo.GetMpiBasicInfoEventPublisher;
import com.demo.events.application.port.in.mpibasicinfo.GetMpiBasicInfoUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMpiBasicInfoEventListener {

    private final GetMpiBasicInfoUseCasePort getMpiBasicInfoUseCasePort;

    @EventListener
    public void getMpiBasicInfo (GetMpiBasicInfoEventPublisher getMpiBasicInfoEventPublisher) {
        this.getMpiBasicInfoUseCasePort.execute(getMpiBasicInfoEventPublisher);
    }
}
