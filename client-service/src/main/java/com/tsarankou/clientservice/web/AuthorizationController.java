package com.tsarankou.clientservice.web;

import com.tsarankou.clientservice.data.entity.User;
import com.tsarankou.clientservice.dto.LoginDto;
import com.tsarankou.clientservice.dto.res.LoginResponse;
import com.tsarankou.clientservice.security.auth.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    private final JwtUtil jwtUtil;
    @PostMapping
    public ResponseEntity<LoginResponse> authorization(@RequestBody LoginDto loginDto) {
//        try {
            Authentication authentication =
                    authenticationManager
                            .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getLogin(),loginDto.getPassword()));

            String login = authentication.getName();
            User user = User.builder().login(login).build();
            String token = jwtUtil.createToken(user);
            System.out.println(token);
            LoginResponse loginRes = new LoginResponse(login,token);
            return ResponseEntity.ok(loginRes);

//        }catch (BadCredentialsException e){
//           System.out.println(e);
//        }catch (Exception e){
             //ErrorRerrorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//        }
//        return null;
    }
}
