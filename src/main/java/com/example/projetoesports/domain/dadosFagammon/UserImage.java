package com.example.projetoesports.domain.dadosFagammon;

import com.example.projetoesports.domain.dadosFagammon.dto.SaveImageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "UserImage")
@Table(schema = "dados_fagammon", name = "user_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserImage {
    @Id
    private Long userId;

    private String image;

    public UserImage(SaveImageDTO saveImageDTO) {
        this.userId = saveImageDTO.userId();
        this.image = saveImageDTO.base64();
    }
}
