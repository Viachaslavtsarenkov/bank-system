package com.tsarankou.clientservice.service.impl;

import com.tsarankou.clientservice.data.entity.User;
import com.tsarankou.clientservice.data.repository.UserRepository;
import com.tsarankou.clientservice.dto.LoginDto;
import com.tsarankou.clientservice.service.EncryptionService;
import com.tsarankou.clientservice.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final EncryptionService encryptionService;
    private final static String ROLE = "CLIENT";
    @Override
    public UserDetails loadUserByLoginAndPassword(LoginDto loginDto) {
        String hashedPassword = encryptionService.digest(loginDto.getPassword());
        User authorizedUser = userRepository.findUserByLoginAndPassword(loginDto.getEmail(),
                hashedPassword);
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(authorizedUser.getSurname().concat(" ")
                                .concat(authorizedUser.getName()))
                        .password(authorizedUser.getPassword())
                        .roles(ROLE)
                        .build();
        return userDetails;
    }
}
