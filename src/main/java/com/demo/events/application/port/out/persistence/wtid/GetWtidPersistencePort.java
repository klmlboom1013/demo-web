package com.demo.events.application.port.out.persistence.wtid;


import com.demo.events.domain.ActivityWtid;

public interface GetWtidPersistencePort {

    String getWtid(ActivityWtid activityWtid);
}
