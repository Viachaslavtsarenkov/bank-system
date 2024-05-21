package com.tsarankou.clientservice.dto;

import lombok.Data;

@Data
public class BankAccountDto {
    private Long id;
    private Long userId;
    private Float deposit;
}
