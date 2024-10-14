package com.example.projetoesports.service.impl;

import com.example.projetoesports.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImplDefault implements UserDetailsService {

    @Autowired
    UserRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserDetails(username);
    }

    private UserDetails getUserDetails(String username) {
        if(username.contains("@") && username.contains(".")){
            return usuarioRepository.findByEmail(username);
        } else {
            return usuarioRepository.findByCpf(username);
        }
    }
}
