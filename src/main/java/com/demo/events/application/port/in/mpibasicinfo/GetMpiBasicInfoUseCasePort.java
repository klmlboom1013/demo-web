package com.demo.events.application.port.in.mpibasicinfo;

import com.demo.events.adapter.out.external.mpibasicinfo.MpiBasicInfoExternal;
import com.demo.events.domain.ActivityMpiBasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

public interface GetMpiBasicInfoUseCasePort {
    Object execute(GetMpiBasicInfoCommand getMpiBasicInfoCommand);


    @Log4j2
    @Service
    @RequiredArgsConstructor
    final class GetMpiBasicInfoService implements GetMpiBasicInfoUseCasePort {

        private final MpiBasicInfoExternal mpiBasicInfoExternal;

        @Override
        public Object execute(GetMpiBasicInfoCommand getMpiBasicInfoCommand) {
            return mpiBasicInfoExternal.getMpiBasicInfoRun(
                    ActivityMpiBasicInfo.builder()
                            .wtid(getMpiBasicInfoCommand.getWtid())
                            .mid(getMpiBasicInfoCommand.getMid())
                            .build());
        }
    }
}
