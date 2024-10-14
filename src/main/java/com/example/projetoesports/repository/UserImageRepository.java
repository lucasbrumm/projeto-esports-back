package com.example.projetoesports.repository;

import com.example.projetoesports.domain.dadosFagammon.UserImage;
import com.example.projetoesports.domain.dadosFagammon.interfaces.IBase64UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage, Long> {
    IBase64UserImage findImageByUserId(Long userId);

    @Query(value = "SELECT image FROM dados_fagammon.user_image WHERE user_id = ?1", nativeQuery = true)
    String findImageByUserIdString(Long userId);
}
