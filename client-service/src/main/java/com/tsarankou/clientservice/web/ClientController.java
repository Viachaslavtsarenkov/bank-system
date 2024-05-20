package com.tsarankou.clientservice.web;

import com.tsarankou.clientservice.dto.ClientDto;
import com.tsarankou.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public String saveNewClient(@RequestBody ClientDto clientDto) {
        //todo
        // check validation
        // return result
        clientService.saveNewClient(clientDto);
        return "String;";
    }
}
