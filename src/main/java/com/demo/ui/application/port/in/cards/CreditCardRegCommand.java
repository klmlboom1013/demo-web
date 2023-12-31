package com.demo.ui.application.port.in.cards;

import com.demo.ui.application.port.in.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditCardRegCommand  extends BaseCommand {
    private String billKey;
}
