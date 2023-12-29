package com.demo.ui.domain;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@ToString
public class ActivityWtid {
    private final String siteDvdCd = "STB";

    @Size(min = 2, max = 2)
    private final String idcDvdCd;
    @Size(min = 8, max = 8)
    private final String currentDate;

    @Setter
    private String wtid;

    @Builder
    public ActivityWtid(String idcDvdCd, String currentDate) {
        this.idcDvdCd=idcDvdCd;
        this.currentDate=currentDate;
    }
}
