DROP TABLE IF EXISTS pricing;

CREATE TABLE pricing(
  pricing_id INT AUTO_INCREMENT PRIMARY KEY,
  brand_id INT NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  product_id INT NOT NULL,
  priority INT NOT NULL,
  price FLOAT NOT NULL,
  currency VARCHAR(50) NOT NULL
);

ALTER TABLE pricing ADD CONSTRAINT uq_price 
UNIQUE(brand_id, start_date, end_date, product_id, priority, price, currency);
