CREATE TABLE dados_fagammon.user_image (
    user_id INTEGER NOT NULL,
    image TEXT,
    FOREIGN KEY (user_id) REFERENCES dados_fagammon.user(id)
);