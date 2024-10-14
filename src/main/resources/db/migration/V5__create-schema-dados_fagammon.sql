CREATE TABLE dados_fagammon.game(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    value TEXT NOT NULL
);

INSERT INTO dados_fagammon.game
    (name, value) VALUES
        ('CS:2', 'cs'),
        ('League Of Legends', 'lol'),
        ('Valorant', 'valorant');