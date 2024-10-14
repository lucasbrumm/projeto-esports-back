CREATE SCHEMA IF NOT EXISTS email;

CREATE TABLE email.email_history(
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,
    sender TEXT NOT NULL,
    receiver TEXT NOT NULL,
    subject TEXT NOT NULL,
    body TEXT NOT NULL
);