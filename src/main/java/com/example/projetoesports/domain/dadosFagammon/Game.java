package com.example.projetoesports.domain.dadosFagammon;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Game")
@Table(schema = "dados_fagammon", name = "game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;
}
