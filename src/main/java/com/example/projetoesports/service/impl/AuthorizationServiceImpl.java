package com.example.projetoesports.service.impl;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.example.projetoesports.domain.dadosFagammon.User;
import com.example.projetoesports.domain.dadosFagammon.UserInformation;
import com.example.projetoesports.domain.dadosFagammon.dto.*;
import com.example.projetoesports.repository.UserInformationRepository;
import com.example.projetoesports.repository.UserRepository;
import com.example.projetoesports.service.AuthorizationService;
import com.example.projetoesports.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserInformationRepository userInformationRepository;

    @Autowired
    private UserInformationService userInformationService;


    @Override
    public ResponseEntity<?> loginUser(AuthenticationDTO authenticationDTO) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            var user = (User) auth.getPrincipal();
            var infoUser = userInformationRepository.findByIdUsuario(user.getId());

            if (infoUser == null) {
                userInformationService.saveInformacoesUsuario(new UserInfromationDTO(user.getId()), false);
            }

            return ResponseEntity.ok().body(token);
        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário desabilitado");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

    @Override
    public ResponseEntity<?> logoutUser(TokenUserDTO tokenUserDTO) {
        tokenService.invalidateToken(tokenUserDTO.token());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> registerUser(RegisterDTO registerDTO) {
        if (this.usuarioRepository.findByCpf(registerDTO.cpf()) != null) {
            return ResponseEntity.badRequest().build();
        }

        User newUser = new User(registerDTO);
        usuarioRepository.save(newUser);

        UserInformation newInfo = new UserInformation();
        newInfo.setIdUsuario(newUser.getId());
        userInformationRepository.save(newInfo);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> account(TokenUserDTO tokenUserDTO) {
        try {
            var validToken = tokenService.validateToken(tokenUserDTO.token());
            User user = (User) usuarioRepository.findByCpf(validToken);
            return ResponseEntity.ok(new UserDTO(user));
//            menssagem de erro para token invalido
        } catch (SignatureVerificationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
