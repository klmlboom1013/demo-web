package com.demo.events.adapter.out.persistence.jnoffctrns;

import com.demo.events.application.port.out.persistence.jnoffctrns.RecodeJnoffcTrnsPersistencePort;
import com.demo.events.domain.RecodeJnoffcTrns;
import org.springframework.stereotype.Component;

@Component
public class RecodeJnoffcTrnsPersistence implements RecodeJnoffcTrnsPersistencePort {
    @Override
    public Integer recodeRun(RecodeJnoffcTrns recodeJnoffcTrns) {
        return 1;
    }
}
