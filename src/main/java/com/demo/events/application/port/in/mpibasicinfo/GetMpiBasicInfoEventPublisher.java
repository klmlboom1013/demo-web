package com.demo.events.application.port.in.mpibasicinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class GetMpiBasicInfoEventPublisher {
    private final String wtid;
    private final String mid;
    private final String searchType;

    @Setter
    private Object mpiBasicInfo;

    @Builder
    public GetMpiBasicInfoEventPublisher(String wtid, String mid, String searchType) {
        this.wtid = wtid;
        this.mid = mid;
        this.searchType = searchType;
    }
}
