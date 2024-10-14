CREATE TABLE IF NOT EXISTS dados_fagammon.rel_screen_user_role(
    id_user_role INT NOT NULL,
    id_screen INT NOT NULL,

    CONSTRAINT fk_rel_screen_user_role_role FOREIGN KEY (id_user_role) REFERENCES dados_fagammon.user_role(id),
    CONSTRAINT fk_rel_screen_user_role_screen FOREIGN KEY (id_screen) REFERENCES dados_fagammon.screen(id)
);