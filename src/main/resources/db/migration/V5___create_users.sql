CREATE TABLE IF NOT EXISTS users
(
  id SERIAL PRIMARY KEY,
  first_name VARCHAR NOT NULL,
  last_name VARCHAR NULL,
  email VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

CREATE UNIQUE INDEX ON users(email);