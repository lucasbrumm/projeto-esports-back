package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.dadosFagammon.Game;
import com.example.projetoesports.repository.GameRepository;
import com.example.projetoesports.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gamesRepository;

    @Override
    public List<Game> findAll() {
        return gamesRepository.findAll();
    }
}
