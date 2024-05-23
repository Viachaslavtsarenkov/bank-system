package com.tsarankou.clientservice.service;

import com.tsarankou.clientservice.dto.LoginDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    public UserDetails loadUserByLoginAndPassword(LoginDto loginDto);
}
