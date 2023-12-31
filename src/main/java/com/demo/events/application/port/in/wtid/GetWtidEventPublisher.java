package com.demo.events.application.port.in.wtid;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class GetWtidEventPublisher {
    private final String idcDvdCd;
    private final String currentDate;

    @Setter
    private String wtid;

    @Builder
    public GetWtidEventPublisher(String idcDvdCd, String currentDate) {
        this.idcDvdCd = idcDvdCd;
        this.currentDate = currentDate;
    }
}
