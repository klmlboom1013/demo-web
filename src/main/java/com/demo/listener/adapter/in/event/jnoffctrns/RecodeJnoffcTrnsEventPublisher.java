package com.demo.listener.adapter.in.event.jnoffctrns;

import lombok.*;

@Getter
@ToString
public class RecodeJnoffcTrnsEventPublisher {
    private final String wtid;
    private final String mid;
    private final String requestJsonStr;

    @Setter
    private Result result;

    @Builder
    public RecodeJnoffcTrnsEventPublisher(String wtid, String mid, String requestJsonStr) {
        this.wtid = wtid;
        this.mid = mid;
        this.requestJsonStr = requestJsonStr;
    }

    @Getter
    @Builder
    @Value
    @ToString
    public static class Result {
        Object data;
    }
}
