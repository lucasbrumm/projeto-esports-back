package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.dadosFagammon.UserImage;
import com.example.projetoesports.domain.dadosFagammon.UserInformation;
import com.example.projetoesports.domain.dadosFagammon.dto.EditNickname;
import com.example.projetoesports.domain.dadosFagammon.dto.UserImageAndNicknameDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.UserInfromationDTO;
import com.example.projetoesports.repository.UserImageRepository;
import com.example.projetoesports.repository.UserInformationRepository;
import com.example.projetoesports.repository.UserRepository;
import com.example.projetoesports.service.UserInformationService;
import com.example.projetoesports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    private UserInformationRepository userInformationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserImageRepository userImageRepository;

    @Override
    public void saveInformacoesUsuario(UserInfromationDTO informacoesUsuarioDTO, boolean handleFirstAcess) {
        var informacoesUsuario = new UserInformation(informacoesUsuarioDTO);
        userInformationRepository.save(informacoesUsuario);
        if (handleFirstAcess) userService.handleFirstAcess(informacoesUsuarioDTO.idUsuario());
    }

    public boolean sameNickname(String cpf) {
        return userInformationRepository.findByNickname(cpf) != null;
    }

    @Override
    public UserInformation getUserInformation(Long userId) {
        UserInformation userInformation = userInformationRepository.findByIdUsuario(userId);
        return userInformation;
    }

    @Override
    public String getNicknameUser(Long userId) {
        UserInformation userInformation = userInformationRepository.findByIdUsuario(userId);
        return userInformation.getNickname();
    }

    @Override
    public UserImageAndNicknameDTO getNicknameAndImage(Long userId) {
        UserInformation userInformation = userInformationRepository.findByIdUsuario(userId);
        String userImage = userImageRepository.findImageByUserIdString(userId);
        UserImageAndNicknameDTO nicknameAndImage = new UserImageAndNicknameDTO(userInformation.getNickname(), userImage);
        return nicknameAndImage;
    }

    @Override
    public ResponseEntity<String> saveNewNickname(EditNickname editNickname) {
        Optional<UserInformation> userInformationOptional = Optional.ofNullable(userInformationRepository.findByIdUsuario(editNickname.userId()));
        if (!userInformationOptional.isPresent()) {
            return new ResponseEntity<>("User with id " + editNickname.userId() + " not found", HttpStatus.NOT_FOUND);
        }

        UserInformation user = userInformationOptional.get();

        if(user.getNickname().equals(editNickname.newNickName())) {
            return new ResponseEntity<>("Same nickname", HttpStatus.BAD_REQUEST);
        }

        if (existsNickname(editNickname.newNickName())){
            return new ResponseEntity<>("Nickname already exists", HttpStatus.BAD_REQUEST);
        }

        user.setNickname(editNickname.newNickName());
        userInformationRepository.save(user);

        return new ResponseEntity<>("Nickname updated successfully", HttpStatus.OK);
    }

    @Override
    public boolean existsNickname(String nickname) {
        Optional<UserInformation> userInformationOptional = Optional.ofNullable(userInformationRepository.findByNickname(nickname));
        return userInformationOptional.isPresent();
    }
}
