package com.tsarankou.clientservice.web;

import com.tsarankou.clientservice.dto.ClientDto;
import com.tsarankou.clientservice.dto.IdDto;
import com.tsarankou.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdDto saveNewClient(@RequestBody ClientDto clientDto) {
        // todo
        // check validation
        return clientService.saveNewClient(clientDto);
    }
}
