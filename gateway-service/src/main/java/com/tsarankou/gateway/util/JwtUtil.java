package com.tsarankou.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUtil {


    private final String secret_key = "mysecretkey";



    public Claims getClaims(final String token) {
        try {
            Claims body = Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
            return body;
        } catch (Exception e) {
            //todo
            System.out.println(e.getMessage() + " => " + e);
        }
        return null;
    }


    public void validateToken(final String token){
        try {
            Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token);
        } catch (SignatureException ex) {
          //  throw new JwtTokenMalformedException("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
//            throw new JwtTokenMalformedException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
//            throw new JwtTokenMalformedException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
//            throw new JwtTokenMalformedException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
//            throw new JwtTokenMissingException("JWT claims string is empty.");
        }
    }


}
