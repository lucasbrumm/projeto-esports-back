CREATE SCHEMA IF NOT EXISTS dados_fagammon ;

CREATE TABLE dados_fagammon.user(
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    password TEXT UNIQUE NOT NULL,
    email TEXT UNIQUE NOT NULL,
    role TEXT NOT NULL,
    enabled BOOLEAN,
    first_access BOOLEAN
);