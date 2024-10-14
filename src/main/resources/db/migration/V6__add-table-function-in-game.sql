CREATE TABLE dados_fagammon.role_game(
     id_game INT,
     id_role SERIAL PRIMARY KEY UNIQUE NOT NULL,
     value TEXT,
     name TEXT,
     FOREIGN KEY (id_game) REFERENCES dados_fagammon.game(id)
);

INSERT INTO dados_fagammon.role_game
    (id_game, value, name) VALUES
      (1, 'entry', 'ENTRY FRAGGER'),
      (1, 'lurker', 'LURKER'),
      (1, 'awper', 'AWPER'),
      (1, 'support', 'SUPPORT'),

      (2, 'top', 'TOP LANER'),
      (2, 'jg', 'JUNGLER'),
      (2, 'mid', 'MID LANER'),
      (2, 'adc', 'ADC'),
      (2, 'sup', 'SUPPORT'),

      (3, 'duelist', 'DUELIST'),
      (3, 'controller', 'CONTROLLER'),
      (3, 'initiator', 'INITIATOR'),
      (3, 'sentinel', 'SENTINEL');