package com.tsarankou.clientservice.client.impl;

import com.tsarankou.clientservice.client.BankAccountClient;
import com.tsarankou.clientservice.config.prop.BankProcessorProperties;
import com.tsarankou.clientservice.dto.BankAccountDto;
import com.tsarankou.clientservice.dto.IdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class BankAccountClientImpl implements BankAccountClient {
    private final WebClient webClient;
    private final BankProcessorProperties bankProperties;
    @Override
    public IdDto createBankAccount(BankAccountDto bankAccountDto) {
        log.info("Sending request to BANK-PROCESSOR service: {}", bankAccountDto);
        IdDto response = webClient.post().uri(uri ->
            uri.scheme(bankProperties.getScheme())
                    .host(bankProperties.getHost())
                    .port(bankProperties.getPort())
                    .path(bankProperties.getEndpoint())
                    .build()).bodyValue(bankAccountDto)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(IdDto.class)
                .block();

        log.info("Received response from BANK-PROCESSOR service: {}", response);
        return response;
    }
}
