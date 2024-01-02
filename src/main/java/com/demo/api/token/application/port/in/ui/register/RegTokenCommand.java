package com.demo.api.token.application.port.in.ui.register;

import com.demo.global.dto.command.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegTokenCommand extends BaseCommand {
    private String billKey;
}
