package com.demo.adapter.out.external;

import com.demo.application.port.out.export.WpaycoreMpiTrnsExportPort;
import com.demo.domain.ActivityWpaycoreMpiTrns;
import com.demo.domain.MapperMpiBasicInfo;
import org.springframework.stereotype.Component;

/**
 * 가맹점 기준정보 조회 Wpaycore 연동
 */
@Component
public class WpaycoreMpiTrnsExternal implements WpaycoreMpiTrnsExportPort {

    @Override
    public MapperMpiBasicInfo getMpiBasicInfoRun(ActivityWpaycoreMpiTrns activityWpaycoreMpiTrns) {
        return MapperMpiBasicInfo.builder().data("Mpi Basic info Success..!!").build();
    }
}
