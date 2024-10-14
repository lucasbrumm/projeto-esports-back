package com.example.projetoesports.repository;

import com.example.projetoesports.domain.dadosFagammon.RoleGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleGameRepository extends JpaRepository<RoleGame, Long>{
    List<RoleGame> findByGameValue(String gameValue);
}
