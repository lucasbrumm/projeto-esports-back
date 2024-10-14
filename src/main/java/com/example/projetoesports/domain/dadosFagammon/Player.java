package com.example.projetoesports.domain.dadosFagammon;

import com.example.projetoesports.domain.dadosFagammon.dto.PlayerDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "player")
@Table(schema = "dados_fagammon", name = "player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPlayer")

public class Player {
    @Id
    private Long idPlayer;
    private Long idGame;
    private Long idRole;

    @OneToOne
    @JoinColumn(name = "id_player", referencedColumnName = "id_usuario")
    private UserInformation informacoesUsuario;

    @OneToOne
    @JoinColumn(name = "id_player", referencedColumnName = "id")
    private User user;

    public Player (PlayerDTO playerDTO) {
        this.idPlayer = playerDTO.idPlayer();
        this.idGame = playerDTO.idGame();
        this.idRole = playerDTO.idRole();
    }
}
