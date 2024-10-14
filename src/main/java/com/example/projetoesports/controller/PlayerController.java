package com.example.projetoesports.controller;

import com.example.projetoesports.domain.dadosFagammon.dto.PlayerDTO;
import com.example.projetoesports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("PlayerController")
@RequestMapping("/api/player")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/save")
    public ResponseEntity<Void> savePlayer(@RequestBody PlayerDTO playerDTO) {
        playerService.savePlayer(playerDTO);
        return ResponseEntity.ok().build();
    }
}
