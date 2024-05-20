package com.tsarankou.clientservice.web;

import com.tsarankou.clientservice.dto.ClientDto;
import com.tsarankou.clientservice.dto.IdDto;
import com.tsarankou.clientservice.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<IdDto> saveNewClient(@Valid @RequestBody ClientDto clientDto) {
        //todo
        // check validation
        return ResponseEntity.ok(clientService.saveNewClient(clientDto));
    }
}
