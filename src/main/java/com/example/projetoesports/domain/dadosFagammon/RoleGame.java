package com.example.projetoesports.domain.dadosFagammon;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "role_game")
@Table(schema = "dados_fagammon", name = "role_game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RoleGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @ManyToOne
    @JoinColumn(name = "id_game", referencedColumnName = "id")
    private Game game;

    private String name;

    private String value;
}
