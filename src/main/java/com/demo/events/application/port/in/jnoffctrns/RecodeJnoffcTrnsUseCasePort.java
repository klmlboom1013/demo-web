package com.demo.events.application.port.in.jnoffctrns;

import com.demo.events.application.port.out.persistence.jnoffctrns.RecodeJnoffcTrnsPersistencePort;
import com.demo.events.domain.RecodeJnoffcTrns;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface RecodeJnoffcTrnsUseCasePort {

    Integer execute(RecodeJnoffcTrnsCommand recodeJnoffcTrnsCommand);

    @Service
    @RequiredArgsConstructor
    final class RecodeJnoffcTrnsService implements RecodeJnoffcTrnsUseCasePort {
        private final RecodeJnoffcTrnsPersistencePort recodeJnoffcTrnsPersistencePort;
        @Override
        public Integer execute(RecodeJnoffcTrnsCommand recodeJnoffcTrnsCommand) {
            return recodeJnoffcTrnsPersistencePort.recodeRun(RecodeJnoffcTrns.builder()
                            .mid(recodeJnoffcTrnsCommand.getMid())
                            .wtid(recodeJnoffcTrnsCommand.getWtid())
                            .requestJsonStr(recodeJnoffcTrnsCommand.getRequestJsonStr())
                            .build());
        }
    }
}
