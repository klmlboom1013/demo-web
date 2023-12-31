package com.demo.events.application.port.out.persistence.jnoffctrns;

import com.demo.events.domain.RecodeJnoffcTrns;

public interface RecodeJnoffcTrnsPersistencePort {

    Integer recodeRun(RecodeJnoffcTrns recodeJnoffcTrns);
}
