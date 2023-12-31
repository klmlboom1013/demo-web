package com.demo.listener.application.port.in.wtid;

import com.demo.listener.application.port.out.persistence.wtid.GetWtidPersistencePort;
import com.demo.listener.domain.ActivityWtid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

public interface GetWtidQuery {

    String getWtid(GetWtidCommand getWtidCommand);

    @Log4j2
    @Service
    @RequiredArgsConstructor
    final class GetWtidService implements GetWtidQuery {

        private final GetWtidPersistencePort getWtidPersistence;

        @Override
        public String getWtid(GetWtidCommand getWtidCommand) {
            return this.getWtidPersistence.getWtid(ActivityWtid.builder()
                    .idcDvdCd(getWtidCommand.getIdcDvdCd())
                    .currentDate(getWtidCommand.getCurrentDate())
                    .build());
        }
    }
}
