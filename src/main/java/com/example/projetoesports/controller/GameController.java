package com.example.projetoesports.controller;

import com.example.projetoesports.domain.dadosFagammon.Game;
import com.example.projetoesports.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    GameService gamesService;

    @GetMapping("/allGames")
    public List<Game> findAllGames() {
        return gamesService.findAll();
    }
}
