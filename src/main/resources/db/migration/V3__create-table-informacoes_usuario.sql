CREATE TABLE dados_fagammon.user_information(
    id_usuario SERIAL PRIMARY KEY UNIQUE NOT NULL,
    nome_usuario TEXT,
    nickname TEXT UNIQUE,
    telefone_usuario TEXT,
    data_nascimento DATE,
    sexo TEXT,
    CEP TEXT,
    rua TEXT,
    numero_casa INT,
    bairro TEXT,
    cidade TEXT,
    estado TEXT,

    FOREIGN KEY (id_usuario) REFERENCES dados_fagammon.user(id)
);