package com.tsarankou.bankprocessor.service.impl;

import com.tsarankou.bankprocessor.data.entity.BankAccount;
import com.tsarankou.bankprocessor.data.repository.BankAccountRepository;
import com.tsarankou.bankprocessor.dto.BankAccountDto;
import com.tsarankou.bankprocessor.dto.IdDto;
import com.tsarankou.bankprocessor.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository accountRepository;
    @Override
    public IdDto createNewBankAccount(BankAccountDto accountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .userId(accountDto.getUserId())
                .deposit(accountDto.getDeposit())
                .build();
        System.out.println(accountDto);
        accountRepository.save(bankAccount);
        log.info("Created account for user id {}", bankAccount.getUserId());
        IdDto response = new IdDto();
        response.setId(bankAccount.getId());
        return response;
    }
}
