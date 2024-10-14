package com.example.projetoesports.controller;

import com.example.projetoesports.domain.dadosFagammon.UserInformation;
import com.example.projetoesports.domain.dadosFagammon.dto.EditNickname;
import com.example.projetoesports.domain.dadosFagammon.dto.UserImageAndNicknameDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.UserInfromationDTO;
import com.example.projetoesports.service.UserInformationService;
import com.example.projetoesports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/informacoes-usuario")
@CrossOrigin("http://localhost:3000/")
public class UserInformationController {

    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private PlayerService playerService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveInformacoesUsuario(@RequestBody UserInfromationDTO informacoesUsuarioDTO) {

        if (userInformationService.sameNickname(informacoesUsuarioDTO.nickname())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        if (informacoesUsuarioDTO.hasEmptyFields()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userInformationService.saveInformacoesUsuario(informacoesUsuarioDTO, true);
        if(informacoesUsuarioDTO.player() != null) {
            playerService.savePlayer(informacoesUsuarioDTO.player());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public UserInformation getInformationUser(@PathVariable Long userId) {
        return userInformationService.getUserInformation(userId);
    }

    @GetMapping("/nickname/{userId}")
    public String getNicknameUser(@PathVariable Long userId) {
        return userInformationService.getNicknameUser(userId);
    }

    @GetMapping("/nickname-and-image/{userId}")
    public UserImageAndNicknameDTO getNicknameUserAndImage(@PathVariable Long userId) {
        return userInformationService.getNicknameAndImage(userId);
    }

    @PostMapping("/saveNickname")
    public ResponseEntity<String> saveNewNickname(@RequestBody EditNickname editNickname) {
        return userInformationService.saveNewNickname(editNickname);
    }
}
