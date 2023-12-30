package com.demo.ui.application.port.in;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentCommand  extends BaseCommand {
    private String pinFlag;
}
