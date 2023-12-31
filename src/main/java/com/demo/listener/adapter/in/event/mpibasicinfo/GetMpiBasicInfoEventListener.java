package com.demo.listener.adapter.in.event.mpibasicinfo;

import com.demo.listener.application.port.in.mpibasicinfo.GetMpiBasicInfoCommand;
import com.demo.listener.application.port.in.mpibasicinfo.GetMpiBasicInfoUseCasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class GetMpiBasicInfoEventListener {

    private final GetMpiBasicInfoUseCasePort getMpiBasicInfoUseCasePort;

    @EventListener
    public void getMpiBasicInfo (GetMpiBasicInfoEventPublisher getMpiBasicInfoEventPublisher) {
        final Object mpiBasicInfo = this.getMpiBasicInfoUseCasePort.execute(GetMpiBasicInfoCommand.builder()
                        .mid(getMpiBasicInfoEventPublisher.getMid())
                        .wtid(getMpiBasicInfoEventPublisher.getWtid())
                        .searchType(getMpiBasicInfoEventPublisher.getSearchType())
                        .build());
        log.info("result mpiBasicInfo: {}", mpiBasicInfo);
        getMpiBasicInfoEventPublisher.setResult(GetMpiBasicInfoEventPublisher.Result.builder()
                        .mpiBasicInfo(mpiBasicInfo)
                        .build());
    }
}
