package com.demo.listener.application.port.out.persistence.jnoffctrns;

import com.demo.listener.domain.RecodeJnoffcTrns;

public interface RecodeJnoffcTrnsPersistencePort {

    Integer recodeRun(RecodeJnoffcTrns recodeJnoffcTrns);
}
