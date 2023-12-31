package com.demo.events.application.port.in.wtid;


import com.demo.events.application.port.out.persistence.GetWtidPersistencePort;
import com.demo.events.domain.ActivityWtid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

public interface GetWtidQuery {

    void getWtid(GetWtidEventPublisher getWtidEventPublisher);

    @Log4j2
    @Service
    @RequiredArgsConstructor
    final class GetWtidService implements GetWtidQuery {

        private final GetWtidPersistencePort getWtidPersistence;

        @Override
        public void getWtid(GetWtidEventPublisher getWtidEventPublisher) {
            final String wtid = this.getWtidPersistence.getWtid(ActivityWtid.builder()
                    .idcDvdCd(getWtidEventPublisher.getIdcDvdCd())
                    .currentDate(getWtidEventPublisher.getCurrentDate())
                    .build());
            log.info("create wtid success! [{}]", wtid);
            getWtidEventPublisher.setWtid(wtid);
        }
    }
}
