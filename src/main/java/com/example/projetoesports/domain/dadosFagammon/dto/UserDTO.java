package com.example.projetoesports.domain.dadosFagammon.dto;


import com.example.projetoesports.domain.dadosFagammon.User;
import org.springframework.security.core.userdetails.UserDetails;

public record UserDTO (Long id, String cpf, String email, Long userRole, boolean enabled, boolean firstAccess) {

    public UserDTO(User usuario) {
        this(usuario.getId(), usuario.getCpf(), usuario.getEmail(), usuario.getUserRole().getId(), usuario.isEnabled(),
                usuario.isFirstAccess());
    }

    public UserDTO(UserDetails userDetails) {
        this(
                ((User) userDetails).getId(), ((User) userDetails).getCpf(), ((User) userDetails).getEmail(),
                ((User) userDetails).getUserRole().getId(), userDetails.isEnabled(), ((User) userDetails).isFirstAccess()
        );
    }
}

