package com.example.SpringProject.Configuration;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtProvider {
    private final String JWT_SECRET = "YouNeedToKeepEveryThingSaveAndStayAwayFromHackerOnceAgainYouNeedToKeepEveryThingSaveAndStayAwayFromHacker";
    private final long JWT_EXPIRATION = 604800000L;

    //Create Jwt from User info
    public String generateToken(CustomUserDetails customUserDetails){
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + JWT_EXPIRATION);

        //Create jwt from username of user
        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }

    public String getUserFromJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    //Validate Token
    public boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
