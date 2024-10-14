package com.example.projetoesports.repository;

import com.example.projetoesports.domain.dadosFagammon.Screen;
import com.example.projetoesports.domain.dadosFagammon.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

    @Query(value = "SELECT * from dados_fagammon.screen scr " +
            "WHERE scr.id IN (SELECT rel.id_screen FROM dados_fagammon.rel_screen_user_role rel " +
            "WHERE rel.id_user_role = :roleId)", nativeQuery = true)
    List<Screen> findScreensByUserId(Long roleId)   ;

}
