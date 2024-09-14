CREATE TABLE IF NOT EXISTS products
(
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  cost real NOT NULL,
  discount int,
  description VARCHAR,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

CREATE INDEX IF NOT EXISTS products_name_idx ON products(name);