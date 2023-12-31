package com.demo.application.port.in;

import com.demo.application.port.out.export.WpaycoreMpiTrnsExportPort;
import com.demo.domain.ActivityWpaycoreMpiTrns;
import com.demo.domain.MapperMpiBasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

public interface MpiBasicInfoUseCasePort {
    MapperMpiBasicInfo execute(BaseCommand command);


    @Log4j2
    @Service
    @RequiredArgsConstructor
    final class MpiBasicInfoService implements MpiBasicInfoUseCasePort {

        private final WpaycoreMpiTrnsExportPort wpaycoreMpiTrnsExport;

        @Override
        public MapperMpiBasicInfo execute(BaseCommand command) {
            return wpaycoreMpiTrnsExport.getMpiBasicInfoRun(
                    ActivityWpaycoreMpiTrns.builder()
                            .wtid(command.getWtid())
                            .mid(command.getMid())
                            .build());
        }
    }
}
