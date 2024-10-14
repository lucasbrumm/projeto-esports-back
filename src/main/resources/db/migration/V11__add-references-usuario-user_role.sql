ALTER TABLE dados_fagammon.user DROP COLUMN role;

ALTER TABLE dados_fagammon.user ADD COLUMN id_user_role INT NOT NULL default 3;

ALTER TABLE dados_fagammon.user ADD CONSTRAINT fk_usuario_role FOREIGN KEY (id_user_role) REFERENCES dados_fagammon.user_role(id);

INSERT INTO dados_fagammon.user (cpf, password, email, enabled, first_access, id_user_role)
VALUES ('11111111111', '$2a$10$SNmn/2Zwc08LIyayEmb2de8NcgTmCLAEW2uIPHJ0GzMInabdqfvO2', 'admin@admin.com', TRUE, TRUE, 1),
       ('22222222222', '$2a$10$kmONbKAx//44.q31yS3dAexXK7PaUHh5kt/C9shlYHyAnIz3TNUgy', 'coach@coach.com', TRUE, TRUE, 2),
       ('33333333333', '$2a$10$9jZs/kBqgIi/tSvbwzx1dO5zDTNDtsu58r3.c6azMBu.fh4j.o.ua', 'player@player.com', TRUE, TRUE, 3);