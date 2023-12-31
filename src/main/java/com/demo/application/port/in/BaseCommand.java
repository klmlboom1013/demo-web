package com.demo.application.port.in;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class BaseCommand {
    @Setter
    private String version;
    @Setter
    private String wtid;
    private final String mid = "INIWpaytst03";
}
