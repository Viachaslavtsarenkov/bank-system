package com.tsarankou.clientservice.web;

import com.tsarankou.clientservice.data.entity.User;
import com.tsarankou.clientservice.dto.LoginDto;
import com.tsarankou.clientservice.dto.res.LoginResponse;
import com.tsarankou.clientservice.security.auth.JwtUtil;
import com.tsarankou.clientservice.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private final EncryptionService encryptionService;
    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<LoginResponse> authorization(@RequestBody LoginDto loginDto) {
        try {
            String password = encryptionService.digest(loginDto.getPassword());
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getLogin(),password));
            String login = authentication.getName();
            User user = User.builder().login(login).build();
            String token = jwtUtil.createToken(user);
            LoginResponse loginRes = new LoginResponse(login,token);
            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
           // ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
           // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
             //ErrorRerrorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        return null;
    }
}
