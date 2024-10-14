CREATE TABLE IF NOT EXISTS dados_fagammon.user_role (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO dados_fagammon.user_role (name) VALUES ('ADMIN'), ('COACH'), ('PLAYER');
