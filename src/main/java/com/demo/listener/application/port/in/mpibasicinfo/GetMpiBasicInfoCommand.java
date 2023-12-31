package com.demo.listener.application.port.in.mpibasicinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class GetMpiBasicInfoCommand {
    private final String wtid;
    private final String mid;
    private final String searchType;

    @Setter
    private Object mpiBasicInfo;

    @Builder
    public GetMpiBasicInfoCommand(String wtid, String mid, String searchType) {
        this.wtid = wtid;
        this.mid = mid;
        this.searchType = searchType;
    }
}
