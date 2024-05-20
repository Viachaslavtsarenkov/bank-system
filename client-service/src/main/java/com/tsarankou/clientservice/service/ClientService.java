package com.tsarankou.clientservice.service;

import com.tsarankou.clientservice.dto.ClientDto;
import com.tsarankou.clientservice.dto.IdDto;

public interface ClientService {
    IdDto saveNewClient(ClientDto clientDto);
}
