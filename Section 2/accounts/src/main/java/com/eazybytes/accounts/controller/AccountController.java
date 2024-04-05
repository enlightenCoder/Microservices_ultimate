package com.eazybytes.accounts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts") //pre path
public class AccountController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello from the accounts controller...";
    }
}
