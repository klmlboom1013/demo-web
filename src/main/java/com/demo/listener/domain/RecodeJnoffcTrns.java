package com.demo.listener.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RecodeJnoffcTrns {
    private final String wtid;
    private final String mid;
    private final String requestJsonStr;
}
