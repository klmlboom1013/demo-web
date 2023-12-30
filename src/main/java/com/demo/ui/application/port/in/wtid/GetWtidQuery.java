package com.demo.ui.application.port.in.wtid;

import com.demo.ui.application.port.in.BaseCommand;
import com.demo.ui.application.port.out.persistence.GetWtidPersistencePort;
import com.demo.ui.domain.ActivityWtid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

public interface GetWtidQuery {

    void getWtid(BaseCommand command);

    @Log4j2
    @Service
    @RequiredArgsConstructor
    final class GetWtidService implements GetWtidQuery {

        private final GetWtidPersistencePort getWtidPersistence;

        @Override
        public void getWtid(BaseCommand command) {
            final String wtid = this.getWtidPersistence.getWtid(ActivityWtid.builder().idcDvdCd("LO").currentDate("20231228").build());
            log.info("create wtid success! [{}]", wtid);
            command.setWtid(wtid);
        }
    }
}
