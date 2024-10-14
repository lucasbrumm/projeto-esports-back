package com.example.projetoesports.repository;

import com.example.projetoesports.domain.dadosFagammon.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long>{
    UserInformation findByNickname(String nickname);
    UserInformation findByIdUsuario(Long idUsuario);
}
