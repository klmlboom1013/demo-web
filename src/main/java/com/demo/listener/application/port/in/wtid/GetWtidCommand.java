package com.demo.listener.application.port.in.wtid;

import lombok.*;

@Getter
@Value
@Builder
@ToString
public class GetWtidCommand {
    String idcDvdCd;
    String currentDate;
}
