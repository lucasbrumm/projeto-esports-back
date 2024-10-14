package com.example.projetoesports.repository;

import com.example.projetoesports.domain.dadosFagammon.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findGameByValue(String value);
}
