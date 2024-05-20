package com.tsarankou.clientservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDto {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String password;
    private String phoneNumber;
    private String email;

}
