package com.tsarankou.clientservice.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String login;
    private String token;
}
