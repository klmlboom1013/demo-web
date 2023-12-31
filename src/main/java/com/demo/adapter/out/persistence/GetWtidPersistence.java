package com.demo.adapter.out.persistence;

import com.demo.application.port.out.persistence.GetWtidPersistencePort;
import com.demo.domain.ActivityWtid;
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
