package com.example.projetoesports.service;

import com.example.projetoesports.domain.dadosFagammon.UserInformation;
import com.example.projetoesports.domain.dadosFagammon.dto.EditNickname;
import com.example.projetoesports.domain.dadosFagammon.dto.UserImageAndNicknameDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.UserInfromationDTO;
import org.springframework.http.ResponseEntity;

public interface UserInformationService {
    void saveInformacoesUsuario(UserInfromationDTO informacoesUsuarioDTO, boolean handleFirstAcess);
    boolean sameNickname(String cpf);
    UserInformation getUserInformation(Long userId);
    String getNicknameUser(Long userId);
    UserImageAndNicknameDTO getNicknameAndImage(Long userId);
    ResponseEntity<String> saveNewNickname(EditNickname editNickname);
    boolean existsNickname(String nickname);
}
