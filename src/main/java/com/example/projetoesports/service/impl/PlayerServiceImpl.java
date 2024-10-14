package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.dadosFagammon.Player;
import com.example.projetoesports.domain.dadosFagammon.dto.PlayerDTO;
import com.example.projetoesports.repository.PlayerRepository;
import com.example.projetoesports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public void savePlayer(PlayerDTO playerDTO) {
        Player newPlayer = new Player(playerDTO);
        playerRepository.save(newPlayer);
    }
}
