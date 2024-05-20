package com.tsarankou.clientservice.service;

import com.tsarankou.clientservice.dto.ClientDto;

public interface ClientService {
    public long saveNewClient(ClientDto clientDto);
}
