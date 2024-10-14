package com.example.projetoesports.controller;

import com.example.projetoesports.domain.dadosFagammon.User;
import com.example.projetoesports.domain.dadosFagammon.dto.SaveImageDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.UserDTO;
import com.example.projetoesports.domain.dadosFagammon.interfaces.IBase64UserImage;
import com.example.projetoesports.exeption.ImageNotFoundException;
import com.example.projetoesports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    UserService usuarioService;

    @PostMapping("/saveUsuario")
    public User saveUsuario () {
        return null;
    }

    @GetMapping("/findByLogin/{cpf}")
    public ResponseEntity<UserDTO> findByLogin (@PathVariable String cpf) {
        return usuarioService.findUserByCpf(cpf);
    }

    @GetMapping("/image/{userId}")
    public ResponseEntity getImage(@PathVariable Long userId) {
        try {
            String userImage = usuarioService.getImageById(userId);
            return ResponseEntity.ok().body(userImage);
        } catch (ImageNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found for user with id " + userId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get image", e);
        }
    }

    @PostMapping("/image/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveImage(@RequestBody SaveImageDTO saveImageDTO) {
        try {
            usuarioService.saveImageBase64(saveImageDTO);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }

    @PostMapping("/image/convertImageBase64")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            var message = usuarioService.convertImageToBase64(file);
            return ResponseEntity.ok().body(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/image/saveImage/{idUser}")
    public ResponseEntity<?> saveFile(@RequestParam("file") MultipartFile file, @PathVariable("idUser") Long idUser) {
        try {
            var message = usuarioService.saveImageFile(file, idUser);
            return ResponseEntity.ok().body(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
