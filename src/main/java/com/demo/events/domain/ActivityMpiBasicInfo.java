package com.demo.events.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@Builder
@Value
@ToString
public class ActivityMpiBasicInfo {
    String wtid;
    String mid;
    String searchType;
}
