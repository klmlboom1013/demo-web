package com.demo.ui.application.port.in.mpibasicinfo;

import com.demo.ui.application.port.in.BaseCommand;
import com.demo.ui.application.port.out.export.WpaycoreMpiTrnsExportPort;
import com.demo.ui.domain.ActivityWpaycoreMpiTrns;
import com.demo.ui.domain.MapperMpiBasicInfo;
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
