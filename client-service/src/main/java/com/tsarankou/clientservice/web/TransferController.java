package com.tsarankou.clientservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/transfer")
public class TransferController {

    @GetMapping
    public String get() {
        return "String";
    }
}
