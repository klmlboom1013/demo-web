package com.demo.application.port.out.persistence;

import com.demo.domain.ActivityWtid;

public interface GetWtidPersistencePort {

    String getWtid(ActivityWtid activityWtid);
}
