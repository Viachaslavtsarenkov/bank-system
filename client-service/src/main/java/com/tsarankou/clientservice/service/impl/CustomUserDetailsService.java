package com.tsarankou.clientservice.service.impl;

import com.tsarankou.clientservice.data.entity.User;
import com.tsarankou.clientservice.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User authorizedUser = userRepository.findUserByLogin(username);
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(authorizedUser.getSurname())
                        .password(authorizedUser.getPassword())
                        .build();
        return userDetails;
    }
}
