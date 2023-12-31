package com.demo.events.application.port.in.jnoffctrns;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@Builder
@Value
@ToString
public class RecodeJnoffcTrnsCommand {
    String wtid;
    String mid;
    String requestJsonStr;
}
