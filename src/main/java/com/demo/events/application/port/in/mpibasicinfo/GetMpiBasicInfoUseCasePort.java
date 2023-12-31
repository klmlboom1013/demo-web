package com.demo.events.application.port.in.mpibasicinfo;

import com.demo.events.adapter.out.external.mpibasicinfo.MpiBasicInfoExternal;
import com.demo.events.domain.ActivityMpiBasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

public interface GetMpiBasicInfoUseCasePort {
    void execute(GetMpiBasicInfoEventPublisher getMpiBasicInfoEventPublisher);


    @Log4j2
    @Service
    @RequiredArgsConstructor
    final class GetMpiBasicInfoService implements GetMpiBasicInfoUseCasePort {

        private final MpiBasicInfoExternal mpiBasicInfoExternal;

        @Override
        public void execute(GetMpiBasicInfoEventPublisher getMpiBasicInfoEventPublisher) {
            final Object mpiBasicInfo = mpiBasicInfoExternal.getMpiBasicInfoRun(
                    ActivityMpiBasicInfo.builder()
                            .wtid(getMpiBasicInfoEventPublisher.getWtid())
                            .mid(getMpiBasicInfoEventPublisher.getMid())
                            .build());
            log.info("result mpiBasicInfo: {}", mpiBasicInfo);
            getMpiBasicInfoEventPublisher.setMpiBasicInfo(mpiBasicInfo);
        }
    }
}
