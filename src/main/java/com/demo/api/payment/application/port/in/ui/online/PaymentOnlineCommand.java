package com.demo.api.payment.application.port.in.ui.online;

import com.demo.global.dto.command.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentOnlineCommand extends BaseCommand {
    private String pinFlag;
}
