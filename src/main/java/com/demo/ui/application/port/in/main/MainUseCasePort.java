package com.demo.ui.application.port.in.main;

import com.demo.ui.application.port.out.export.WpaycoreMpiTrnsExportPort;
import com.demo.ui.domain.ActivityWpaycoreMpiTrns;
import com.demo.ui.domain.MapperMpiBasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

public interface MainUseCasePort {
    MapperMpiBasicInfo execute(Object command);


    @Log4j2
    @Service
    @RequiredArgsConstructor
    final class MainService implements MainUseCasePort {

        private final WpaycoreMpiTrnsExportPort wpaycoreMpiTrnsExport;

        @Override
        public MapperMpiBasicInfo execute(Object command) {
            return wpaycoreMpiTrnsExport.getMpiBasicInfoRun(
                    ActivityWpaycoreMpiTrns.builder()
                            .wtid(((BillingSignupCommand) command).getWtid())
                            .mid(((BillingSignupCommand) command).getMid())
                            .build());
        }
    }
}
