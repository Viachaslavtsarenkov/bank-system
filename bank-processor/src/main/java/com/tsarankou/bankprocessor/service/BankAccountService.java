package com.tsarankou.bankprocessor.service;

import com.tsarankou.bankprocessor.dto.BankAccountDto;
import com.tsarankou.bankprocessor.dto.IdDto;

public interface BankAccountService {
    IdDto createNewBankAccount(BankAccountDto accountDto);
}
