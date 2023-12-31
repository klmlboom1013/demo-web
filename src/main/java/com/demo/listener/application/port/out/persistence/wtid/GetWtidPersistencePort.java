package com.demo.listener.application.port.out.persistence.wtid;


import com.demo.listener.domain.ActivityWtid;

public interface GetWtidPersistencePort {

    String getWtid(ActivityWtid activityWtid);
}
