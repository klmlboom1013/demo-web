package com.demo.events.application.port.out.export;


import com.demo.events.domain.ActivityMpiBasicInfo;
import com.demo.events.domain.MapperMpiBasicInfo;

public interface WpaycoreMpiTrnsExportPort {

    MapperMpiBasicInfo getMpiBasicInfoRun(ActivityMpiBasicInfo activityMpiBasicInfo);
}
