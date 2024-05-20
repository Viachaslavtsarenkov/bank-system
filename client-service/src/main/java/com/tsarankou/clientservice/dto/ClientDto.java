package com.tsarankou.clientservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class ClientDto {
    @NonNull
    private String surname;
    @NotBlank
    private String name;
    @NotBlank
    private String patronymic;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    @NotBlank
    @Size(min = 10, message = "Minimum password length is 10")
    private String password;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @Min(0)
    private float deposit;

}
