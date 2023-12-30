package com.demo.ui.application.port.in;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditCardRegCommand  extends BaseCommand {
    private String billKey;
}
