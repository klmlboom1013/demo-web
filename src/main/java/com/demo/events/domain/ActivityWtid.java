package com.demo.events.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class ActivityWtid {
    private final String siteDvdCd = "STB";
    private final String idcDvdCd;
    private final String currentDate;

    @Setter
    private String wtid;

    @Builder
    public ActivityWtid(String idcDvdCd, String currentDate) {
        this.idcDvdCd=idcDvdCd;
        this.currentDate=currentDate;
    }
}
