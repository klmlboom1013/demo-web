package com.demo.ui.application.port.out.persistence;

import com.demo.ui.domain.ActivityWtid;

public interface GetWtidPersistencePort {

    String getWtid(ActivityWtid activityWtid);
}
