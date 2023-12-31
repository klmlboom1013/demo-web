package com.demo.listener.adapter.out.persistence.jnoffctrns;

import com.demo.listener.application.port.out.persistence.jnoffctrns.RecodeJnoffcTrnsPersistencePort;
import com.demo.listener.domain.RecodeJnoffcTrns;
import org.springframework.stereotype.Component;

@Component
public class RecodeJnoffcTrnsPersistence implements RecodeJnoffcTrnsPersistencePort {
    @Override
    public Integer recodeRun(RecodeJnoffcTrns recodeJnoffcTrns) {
        return 1;
    }
}
