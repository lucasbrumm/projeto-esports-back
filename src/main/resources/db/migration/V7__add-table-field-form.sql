CREATE SCHEMA IF NOT EXISTS formulario;

CREATE TABLE formulario.field_form (
    id SERIAL PRIMARY KEY,
    label VARCHAR(100) NOT NULL,
    value VARCHAR(100) NOT NULL,
    type JSONB NOT NULL,
    more_field JSONB DEFAULT NULL,
    required BOOLEAN DEFAULT FALSE,
    disabled BOOLEAN DEFAULT FALSE
);

INSERT INTO formulario.field_form
    (label, value, type, more_field, required, disabled) VALUES
    ('Cpf', 'cpf', '{"type": "text"}', null, true, true),
    ('Email', 'email', '{"type": "email"}', null, true, true),
    ('Nome', 'nomeUsuario', '{"type": "text"}', null, true, false),
    ('Nickname', 'nickname', '{"type": "text"}', null, true, false),
    ('Telefone', 'telefone', '{"type": "text"}', null, true, false),
    ('Nascimento', 'dataNasc', '{"type": "date"}', null, true, false),
    ('Sexo', 'sexo', '{"type": "select"}', null, true, false),
    ('CEP', 'cep', '{"type": "search"}', null, true, false),
    ('Rua', 'rua', '{"type": "text"}', '{"label":"Nº", "value": "numeroCasa", "type":  "number", "width":  50}', true, false),
    ('Bairro', 'bairro', '{"type": "text"}', null, true, false),
    ('Cidade', 'cidade', '{"type": "text"}', null, true, false),
    ('Estado', 'estado', '{"type": "text"}', null, true, false);


-- INSERT INTO formulario.cadastro_fields
-- (label, value, type, required, disabled) VALUES
--      ('Cpf', 'cpf', '{"type": "text"}', true, true),
--      ('Email', 'email', '{"type": "email"}', true, true),
--      ('Nome', 'nome', '{"type": "text"}', true, false),
--      ('Nickname', 'nickname', '{"type": "text"}', true, false),
--      ('Telefone', 'telefone', '{"type": "text"}', true, false),
--      ('Nascimento', 'dataNasc', '{"type": "date"}', true, false),
--      ('Sexo', 'sexo', '{"type": "select"}', true, false),
--      ('CEP', 'cep', '{"type": "search"}', true, false),
--      ('Rua', 'rua', '{"type": "text"}', true, false),
--      ('Bairro', 'bairro', '{"type": "text"}', true, false),
--      ('Cidade', 'cidade', '{"type": "text"}', true, false),
--      ('Estado', 'estado', '{"type": "text"}', true, false);

-- INSERT INTO formulario.cadastro_fields
-- (label, value, type, options ,required, disabled) VALUES
--      ('Cpf', 'cpf', '{"type": "text"}', null, true, true),
--      ('Email', 'email', '{"type": "email"}', null, true, true),
--      ('Nome', 'nome', '{"type": "text"}', null, true, false),
--      ('Nickname', 'nickname', '{"type": "text"}', null, true, false),
--      ('Telefone', 'telefone', '{"type": "text"}', null, true, false),
--      ('Nascimento', 'dataNasc', '{"type": "date"}', null, true, false),
--      ('Sexo', 'sexo', '{"type": "select"}', null, true, false),
--      ('CEP', 'cep', '{"type": "search"}', null, true, false),
--      ('Rua', 'rua', '{"type": "text"}', null, true, false),
--      ('Nº', 'nCasa', '{"type": "number"}', null, true, false),
--      ('Bairro', 'bairro', '{"type": "text"}', null, true, false),
--      ('Cidade', 'cidade', '{"type": "text"}', null, true, false),
--      ('Estado', 'estado', '{"type": "text"}', null, true, false);



