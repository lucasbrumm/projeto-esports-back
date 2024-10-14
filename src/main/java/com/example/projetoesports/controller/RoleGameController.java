package com.example.projetoesports.controller;

import com.example.projetoesports.domain.dadosFagammon.dto.ResponseRoleGameDTO;
import com.example.projetoesports.service.RoleGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game/role")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleGameController {

    @Autowired
    RoleGameService roleGameService;

    @PostMapping("/{valueGame}")
    public List<ResponseRoleGameDTO> findRoleGameByIdGame(@PathVariable String valueGame) {
        return roleGameService.findRoleGameByName(valueGame);
    }

    @GetMapping("/allRoles")
    public List<ResponseRoleGameDTO> findAllRole() {
        return roleGameService.findAllRole();
    }
}
