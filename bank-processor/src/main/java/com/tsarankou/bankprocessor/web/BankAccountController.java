package com.tsarankou.bankprocessor.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    @GetMapping
    public String saveNewAccount() {
        return "response";
    }
}
