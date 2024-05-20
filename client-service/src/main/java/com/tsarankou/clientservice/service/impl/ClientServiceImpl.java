package com.tsarankou.clientservice.service.impl;

import com.tsarankou.clientservice.data.entity.Email;
import com.tsarankou.clientservice.data.entity.PhoneNumber;
import com.tsarankou.clientservice.data.entity.User;
import com.tsarankou.clientservice.data.repository.UserRepository;
import com.tsarankou.clientservice.dto.ClientDto;
import com.tsarankou.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final UserRepository userRepository;
    @Override
    @Transactional
    public long saveNewClient(ClientDto clientDto) {

        PhoneNumber phoneNumber = PhoneNumber.builder()
                .phone(clientDto.getPhoneNumber())
                        .build();

        Email email = Email.builder()
                .email(clientDto.getEmail())
                .build();

//        if(userRepository.existsByPhoneNumbersOrEmailList(List.of(phoneNumber), List.of(email))) {
//            //todo exception
//            // change checking email and phone number
//        }  else {
            User user = User.builder()
                    .surname(clientDto.getSurname())
                    .name(clientDto.getName())
                    .patronymic(clientDto.getPatronymic())
                    .dateOfBirth(clientDto.getDateOfBirth())
                    .password(clientDto.getPassword())
                    .build();
            user.setEmailList(List.of(email));
            user.setPhoneNumbers(List.of(phoneNumber));
            //todo
            // logging
            // create bank account
            // return result
            // encrypt password
            userRepository.save(user);
        //}
        return 0;
    }
}
