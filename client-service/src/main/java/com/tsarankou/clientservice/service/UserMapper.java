package com.tsarankou.clientservice.service;

import com.tsarankou.clientservice.data.entity.User;
import com.tsarankou.clientservice.dto.ClientDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {
    User toEntity(ClientDto clientDto);
}
