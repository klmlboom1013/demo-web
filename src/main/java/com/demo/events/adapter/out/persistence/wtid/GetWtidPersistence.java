package com.demo.events.adapter.out.persistence.wtid;

import com.demo.events.application.port.out.persistence.GetWtidPersistencePort;
import com.demo.events.domain.ActivityWtid;
import org.springframework.stereotype.Component;

/**
 * WTID 생성
 */
@Component
public class GetWtidPersistence implements GetWtidPersistencePort {

    @Override
    public String getWtid(ActivityWtid activityWtid) {
        activityWtid.setWtid(String.format("%s%s%s0000001", activityWtid.getIdcDvdCd(), activityWtid.getSiteDvdCd(), activityWtid.getCurrentDate()));
        return activityWtid.getWtid();
    }
}
