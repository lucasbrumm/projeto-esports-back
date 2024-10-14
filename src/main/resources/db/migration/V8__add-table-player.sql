CREATE TABLE dados_fagammon.player (
    id_player SERIAL PRIMARY KEY,
    id_game INT NOT NULL,
    id_role INT NOT NULL,
    FOREIGN KEY (id_player) REFERENCES dados_fagammon.user(id),
    FOREIGN KEY (id_game) REFERENCES dados_fagammon.game(id),
    FOREIGN KEY (id_role) REFERENCES dados_fagammon.role_game(id_role)
);