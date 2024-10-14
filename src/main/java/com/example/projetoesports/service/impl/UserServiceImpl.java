package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.dadosFagammon.Screen;
import com.example.projetoesports.domain.dadosFagammon.User;
import com.example.projetoesports.domain.dadosFagammon.UserImage;
import com.example.projetoesports.domain.dadosFagammon.UserInformation;
import com.example.projetoesports.domain.dadosFagammon.dto.SaveImageDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.UserDTO;
import com.example.projetoesports.domain.dadosFagammon.interfaces.IBase64UserImage;
import com.example.projetoesports.exeption.ImageNotFoundException;
import com.example.projetoesports.repository.UserImageRepository;
import com.example.projetoesports.repository.UserRepository;
import com.example.projetoesports.service.UserService;
import com.example.projetoesports.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final List<String> ACCEPTED_FORMATS = Arrays.asList("jpg", "png", "tiff", "bmp", "gif", "webp", "svg", "ico");


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserImageRepository userImageRepository;

    @Override
    public User saveUsuario() {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> findUserByCpf(String cpf) {
        UserDetails foundUser = userRepository.findByCpf(cpf);
        if (foundUser != null) {
            UserDTO userDTO = new UserDTO(foundUser);
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void handleFirstAcess(Long idUsuario) {
        User user = userRepository.findUserById(idUsuario);
        user.setFirstAccess(false);
        userRepository.save(user);
    }

    @Override
    public List<Screen> getScreenByUserId() {
        return List.of();
    }

    @Override
    public String getImageById(Long userId) throws ImageNotFoundException {
        String userImage = userImageRepository.findImageByUserIdString(userId);
        if (userImage == null) {
            throw new ImageNotFoundException("Image not found for user with id " + userId);
        }
        return userImage;
    }

    @Override
    public ResponseEntity<?> saveImageBase64(SaveImageDTO saveImageDTO) {
        var userImage = new UserImage(saveImageDTO);
        UserImage savedUserImage = userImageRepository.save(userImage);
        return ResponseEntity.ok(savedUserImage);
    }

    @Override
    public String convertImageToBase64(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File must not be null or empty");
        }

        String formatFile = file.getOriginalFilename().split("\\.")[1];
        if (!ACCEPTED_FORMATS.contains(formatFile)) {
            throw new IllegalArgumentException("Invalid file format. Accepted formats are " + ACCEPTED_FORMATS);
        }

        String encodedString = ConvertUtils.convertImageToBase64(file);
        return encodedString;
    }

    @Override
    public String saveImageFile(MultipartFile file, Long idUser) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File must not be null or empty");
        }

        Optional<User> userOptional = userRepository.findById(idUser);
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User with id " + idUser + " does not exist");
        }

        String imageBase64 = ConvertUtils.convertImageToBase64(file);
        User user = userOptional.get();
        UserImage userImage = new UserImage(user.getId(), imageBase64);
        userImageRepository.save(userImage);
        return imageBase64;
    }
}
