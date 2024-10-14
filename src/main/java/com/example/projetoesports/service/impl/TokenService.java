package com.example.projetoesports.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.projetoesports.domain.dadosFagammon.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private Map<String, Instant> blacklistedTokens = new HashMap<>();

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getCpf())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error na geração do token", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token);
            if (blacklistedTokens.containsKey(token) && Instant.now().isBefore(blacklistedTokens.get(token))) {
                throw new RuntimeException("Token inválido");
            }
            return jwt.getSubject();
        } catch (JWTCreationException exception) {
            return "";
        }
    }

    public void invalidateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token);
            if (blacklistedTokens.containsKey(token) && Instant.now().isBefore(blacklistedTokens.get(token))) {
                throw new RuntimeException("Token já invalidado");
            }
            blacklistedTokens.put(token, jwt.getExpiresAt().toInstant());
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Token inválido", exception);
        }
    }

    public void clearBlacklistedTokens() {
        blacklistedTokens.clear();
    }

//    function to generate expiration date for token
    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
    }


}
