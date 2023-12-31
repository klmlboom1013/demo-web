package com.demo.listener.adapter.out.external.mpibasicinfo;

import com.demo.listener.application.port.out.export.WpaycoreMpiTrnsExportPort;
import com.demo.listener.domain.ActivityMpiBasicInfo;
import com.demo.listener.domain.MapperMpiBasicInfo;
import org.springframework.stereotype.Component;

/**
 * 가맹점 기준정보 조회 Wpaycore 연동
 */
@Component
public class MpiBasicInfoExternal implements WpaycoreMpiTrnsExportPort {

    @Override
    public MapperMpiBasicInfo getMpiBasicInfoRun(ActivityMpiBasicInfo activityMpiBasicInfo) {
        return MapperMpiBasicInfo.builder().data("Mpi Basic info Success..!!").build();
    }
}
