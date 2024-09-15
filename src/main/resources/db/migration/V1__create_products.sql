CREATE TABLE IF NOT EXISTS products
(
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  cost real NOT NULL,
  discount int,
  in_stock BOOLEAN DEFAULT FALSE,
  tags VARCHAR, -- normalize later if needed --
  description VARCHAR,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

CREATE UNIQUE INDEX ON products(name);