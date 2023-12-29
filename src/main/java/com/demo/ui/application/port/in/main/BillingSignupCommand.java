package com.demo.ui.application.port.in.main;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BillingSignupCommand {
    private String version;
    private String wtid;
    private String mid = "INIWpaytst03";
    private String pinFlag;
}
