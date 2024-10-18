CREATE TABLE IF NOT EXISTS inventory
  (
    id SERIAL PRIMARY KEY,
    product_id SERIAL REFERENCES products(id),
    quantity INTEGER DEFAULT 0,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

CREATE UNIQUE INDEX ON inventory(product_id);