package com.example.projetoesports.service;

import com.example.projetoesports.domain.dadosFagammon.Game;

import java.util.List;

public interface GameService {
    List<Game> findAll();
}
