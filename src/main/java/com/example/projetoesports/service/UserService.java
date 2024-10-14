package com.example.projetoesports.service;

import com.example.projetoesports.domain.dadosFagammon.Screen;
import com.example.projetoesports.domain.dadosFagammon.User;
import com.example.projetoesports.domain.dadosFagammon.dto.SaveImageDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.UserDTO;
import com.example.projetoesports.domain.dadosFagammon.interfaces.IBase64UserImage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User saveUsuario();
    ResponseEntity<UserDTO> findUserByCpf(String cpf);
    void handleFirstAcess(Long idUsuario);
    List<Screen> getScreenByUserId();
    String getImageById(Long userId);
    ResponseEntity<?> saveImageBase64(SaveImageDTO saveImageDTO);
    String convertImageToBase64(MultipartFile file);
    String saveImageFile(MultipartFile file, Long idUser);
}
