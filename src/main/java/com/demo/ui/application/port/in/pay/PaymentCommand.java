package com.demo.ui.application.port.in.pay;

import com.demo.ui.application.port.in.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentCommand  extends BaseCommand {
    private String pinFlag;
}
