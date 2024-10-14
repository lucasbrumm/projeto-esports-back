package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.dadosFagammon.Game;
import com.example.projetoesports.domain.dadosFagammon.RoleGame;
import com.example.projetoesports.domain.dadosFagammon.dto.ResponseRoleGameDTO;
import com.example.projetoesports.repository.GameRepository;
import com.example.projetoesports.repository.RoleGameRepository;
import com.example.projetoesports.service.RoleGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleGameServiceImpl implements RoleGameService {

    @Autowired
    RoleGameRepository roleGameRepository;

    @Autowired
    GameRepository gameRepository;

    @Override
    public List<ResponseRoleGameDTO> findRoleGameByName(String valueGame) {
        List<RoleGame> roles = roleGameRepository.findByGameValue(valueGame);
        List<ResponseRoleGameDTO> rolesResponse = new ArrayList<>();
        Game game = gameRepository.findGameByValue(valueGame);
        validateGameAndRole(game, roles);
        addRoleDTO(roles, rolesResponse, game);
        return rolesResponse;
    }

    public List<ResponseRoleGameDTO> findAllRole() {
        List<RoleGame> roles = roleGameRepository.findAll();
        List<ResponseRoleGameDTO> rolesResponse = new ArrayList<>();
        roles.forEach(role -> {
//            rolesResponse.add(new ResponseRoleGameDTO(role.getIdRole(), role.getGame().getValue(), role.getGame().getName(), role.getValue(), role.getName()));
            rolesResponse.add(new ResponseRoleGameDTO(role.getIdRole(), role.getValue(), role.getName(),
                    role.getGame().getId(), role.getGame().getValue(), role.getGame().getName()));
        });
        return rolesResponse;
    }

    private void addRoleDTO(List<RoleGame> roles, List<ResponseRoleGameDTO> rolesResponse, Game game) {
        roles.forEach(role -> {
            rolesResponse.add(new ResponseRoleGameDTO(role.getIdRole(), role.getValue(), role.getName(),
                    game.getId(), game.getValue(), game.getName()));
        });
    }

    private void validateGameAndRole(Game game, List<RoleGame> byGameValue) {
        if(game == null) {
            throw new RuntimeException("Game not found");
        }
        if(byGameValue.isEmpty()) {
            throw new RuntimeException("Role not found");
        }
    }
}
