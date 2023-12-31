package com.demo.listener.adapter.out.persistence.wtid;

import com.demo.listener.application.port.out.persistence.wtid.GetWtidPersistencePort;
import com.demo.listener.domain.ActivityWtid;
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
