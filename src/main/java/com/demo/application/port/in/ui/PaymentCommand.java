package com.demo.application.port.in.ui;

import com.demo.application.port.in.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentCommand  extends BaseCommand {
    private String pinFlag;
}
