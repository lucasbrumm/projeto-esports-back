package com.example.projetoesports.repository;

import com.example.projetoesports.domain.dadosFagammon.Screen;
import com.example.projetoesports.domain.dadosFagammon.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByCpf(String cpf);

    User findByEmail(String email);

    User findUserById(Long id);
}
