package com.demo.listener.application.port.out.export;


import com.demo.listener.domain.ActivityMpiBasicInfo;
import com.demo.listener.domain.MapperMpiBasicInfo;

public interface WpaycoreMpiTrnsExportPort {

    MapperMpiBasicInfo getMpiBasicInfoRun(ActivityMpiBasicInfo activityMpiBasicInfo);
}
