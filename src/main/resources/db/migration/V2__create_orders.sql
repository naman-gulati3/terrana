CREATE TABLE IF NOT EXISTS orders
(
  id SERIAL PRIMARY KEY,
  order_unique_id VARCHAR NOT NULL,
  shipping_address VARCHAR NOT NULL,
  tracking_number BIGINT,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
  product_id SERIAL REFERENCES products(id) ON DELETE RESTRICT
);


CREATE INDEX IF NOT EXISTS orders_order_unique_id ON orders(order_unique_id);
