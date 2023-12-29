package com.demo.ui.application.port.out.export;

import com.demo.ui.domain.ActivityWpaycoreMpiTrns;
import com.demo.ui.domain.MapperMpiBasicInfo;

public interface WpaycoreMpiTrnsExportPort {

    MapperMpiBasicInfo getMpiBasicInfoRun(ActivityWpaycoreMpiTrns activityWpaycoreMpiTrns);
}
