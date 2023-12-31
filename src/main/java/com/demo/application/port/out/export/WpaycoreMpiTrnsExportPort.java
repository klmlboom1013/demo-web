package com.demo.application.port.out.export;

import com.demo.domain.ActivityWpaycoreMpiTrns;
import com.demo.domain.MapperMpiBasicInfo;

public interface WpaycoreMpiTrnsExportPort {

    MapperMpiBasicInfo getMpiBasicInfoRun(ActivityWpaycoreMpiTrns activityWpaycoreMpiTrns);
}
