package com.demo.events.application.port.in.wtid;

import lombok.*;

@Getter
@Value
@Builder
@ToString
public class GetWtidCommand {
    String idcDvdCd;
    String currentDate;
}
