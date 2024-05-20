package com.tsarankou.clientservice.service.impl;

import com.tsarankou.clientservice.data.entity.Email;
import com.tsarankou.clientservice.data.entity.PhoneNumber;
import com.tsarankou.clientservice.data.entity.User;
import com.tsarankou.clientservice.data.repository.EmailRepository;
import com.tsarankou.clientservice.data.repository.PhoneNumberRepository;
import com.tsarankou.clientservice.data.repository.UserRepository;
import com.tsarankou.clientservice.dto.ClientDto;
import com.tsarankou.clientservice.dto.IdDto;
import com.tsarankou.clientservice.service.ClientService;
import com.tsarankou.clientservice.service.exception.DataAlreadyTaken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    @Override
    @Transactional
    public IdDto saveNewClient(ClientDto clientDto) {

        if(phoneNumberRepository.existsPhoneNumberByPhoneIn(List.of(clientDto.getPhoneNumber()))) {
            log.error("Phone number {} already taken", clientDto.getPhoneNumber());
            throw new DataAlreadyTaken();
        }
        if(emailRepository.existsEmailByEmailIn(List.of(clientDto.getEmail()))) {
            log.error("Email {} already taken", clientDto.getEmail());
            throw new DataAlreadyTaken("Email is already taken" + clientDto.getEmail());
        }

        PhoneNumber phoneNumber = PhoneNumber.builder()
                .phone(clientDto.getPhoneNumber())
                .build();

        Email email = Email.builder()
                .email(clientDto.getEmail())
                .build();

        User user = User.builder()
                .surname(clientDto.getSurname())
                .name(clientDto.getName())
                .patronymic(clientDto.getPatronymic())
                .dateOfBirth(clientDto.getDateOfBirth())
                .password(clientDto.getPassword())
                .build();

        phoneNumber.setUser(user);
        email.setUser(user);
        user.setPhoneNumbers(List.of(phoneNumber));
        user.setEmailList(List.of(email));
            //todo
            // create bank account
            // encrypt password
        userRepository.save(user);
        log.info("Created user with id:{}", user.getId());
        IdDto response = new IdDto();
        response.setId(user.getId());
        return response;
    }
}
