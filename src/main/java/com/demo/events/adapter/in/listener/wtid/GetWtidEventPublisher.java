package com.demo.events.adapter.in.listener.wtid;

import lombok.*;

@Getter
@ToString
public class GetWtidEventPublisher {
    private final String idcDvdCd;
    private final String currentDate;

    @Setter
    private Result result;

    @Builder
    public GetWtidEventPublisher(String idcDvdCd, String currentDate) {
        this.idcDvdCd = idcDvdCd;
        this.currentDate = currentDate;
    }

    @Getter
    @Builder
    @Value
    @ToString
    public static class Result {
        String wtid;
    }
}
