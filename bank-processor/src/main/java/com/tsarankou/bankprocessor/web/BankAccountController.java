package com.tsarankou.bankprocessor.web;

import com.tsarankou.bankprocessor.dto.BankAccountDto;
import com.tsarankou.bankprocessor.dto.IdDto;
import com.tsarankou.bankprocessor.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService accountService;
    @PostMapping
    public IdDto createNewAccount(@RequestBody BankAccountDto accountDto) {
        return accountService.createNewBankAccount(accountDto);
    }
}
