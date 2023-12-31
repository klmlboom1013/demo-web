package com.demo.events.adapter.in.listener.mpibasicinfo;

import lombok.*;

@Getter
@ToString
public class GetMpiBasicInfoEventPublisher {
    private final String wtid;
    private final String mid;
    private final String searchType;

    @Setter
    private Result result;


    @Builder
    public GetMpiBasicInfoEventPublisher(String wtid, String mid, String searchType) {
        this.wtid = wtid;
        this.mid = mid;
        this.searchType = searchType;
    }

    @Getter
    @Builder
    @Value
    @ToString
    public static class Result {
        Object mpiBasicInfo;
    }
}
