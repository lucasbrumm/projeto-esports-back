CREATE TABLE IF NOT EXISTS dados_fagammon.screen (
      id SERIAL PRIMARY KEY,
      screen_name TEXT NOT NULL UNIQUE,
      text TEXT NOT NULL,
      route TEXT NOT NULL,
      icon TEXT NOT NULL,
      description TEXT NOT NULL,
      visible boolean NOT NULL,
      order_visible int NOT NULL UNIQUE
);
