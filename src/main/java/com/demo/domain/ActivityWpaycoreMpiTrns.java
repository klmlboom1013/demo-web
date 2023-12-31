package com.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@Builder
@Value
@ToString
public class ActivityWpaycoreMpiTrns {
    String wtid;
    String mid;
    String searchType;
}
