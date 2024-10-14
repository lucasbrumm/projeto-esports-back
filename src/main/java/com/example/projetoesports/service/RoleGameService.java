package com.example.projetoesports.service;

import com.example.projetoesports.domain.dadosFagammon.dto.ResponseRoleGameDTO;

import java.util.List;

public interface RoleGameService {
    List<ResponseRoleGameDTO> findRoleGameByName(String valueGame);

    List<ResponseRoleGameDTO> findAllRole();
}
