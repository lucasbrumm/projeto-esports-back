package com.example.projetoesports.controller;


import com.example.projetoesports.domain.dadosFagammon.dto.AuthenticationDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.RegisterDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.TokenUserDTO;
import com.example.projetoesports.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000/")
public class AuthenticationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        return authorizationService.loginUser(authenticationDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody @Valid TokenUserDTO tokenUserDTO) {
        return authorizationService.logoutUser(tokenUserDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO) {
        return authorizationService.registerUser(registerDTO);
    }

    @PostMapping("/account")
    public ResponseEntity<?> validateToken(@RequestBody @Valid TokenUserDTO tokenUserDTO) {
        return authorizationService.account(tokenUserDTO);
    }
}
