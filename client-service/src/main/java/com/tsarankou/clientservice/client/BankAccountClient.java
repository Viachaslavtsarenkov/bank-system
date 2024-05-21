package com.tsarankou.clientservice.client;

import com.tsarankou.clientservice.dto.BankAccountDto;
import com.tsarankou.clientservice.dto.IdDto;

public interface BankAccountClient {
    IdDto createBankAccount(BankAccountDto bankAccountDto);
}
