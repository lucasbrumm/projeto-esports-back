package com.example.projetoesports.service;

import com.example.projetoesports.domain.dadosFagammon.dto.AuthenticationDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.RegisterDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.TokenUserDTO;
import org.springframework.http.ResponseEntity;

public interface AuthorizationService {
    ResponseEntity<?> loginUser(AuthenticationDTO authenticationDTO);
    ResponseEntity<?> logoutUser(TokenUserDTO tokenUserDTO);
    ResponseEntity<?> registerUser(RegisterDTO registerDTO);
    ResponseEntity<?> account(TokenUserDTO tokenUserDTO);
}
