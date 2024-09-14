CREATE TABLE IF NOT EXISTS product_category
(
  id SERIAL PRIMARY KEY,
  product_id SERIAL REFERENCES products(id) ON DELETE RESTRICT,
  category_id SERIAL REFERENCES category(id) ON DELETE RESTRICT,
  description VARCHAR,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

CREATE INDEX IF NOT EXISTS product_category_product_id_category_id_idx ON product_category(product_id, category_id);
