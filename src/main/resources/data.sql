DROP TABLE IF EXISTS pricing;

CREATE TABLE pricing(
  pricingId INT AUTO_INCREMENT PRIMARY KEY,
  brand_id INT NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  product_id INT NOT NULL,
  priority INT NOT NULL,
  price FLOAT NOT NULL,
  curr VARCHAR(50) NOT NULL
);

ALTER TABLE pricing ADD CONSTRAINT uq_price 
UNIQUE(brand_id, start_date, end_date, product_id, priority, price, curr);


INSERT INTO pricing (brand_id, start_date, end_date, product_id, priority, price, curr) VALUES 
(1,'2020-06-14 00:00:00','2020-12-31 23:59:59', 35455, 0, 35.50, 'EUR');
INSERT INTO pricing (brand_id, start_date, end_date, product_id, priority, price, curr) VALUES
(2,'2020-06-14 15:00:00','2020-06-14 18:30:00', 35455, 1, 25.45, 'EUR');
INSERT INTO pricing (brand_id, start_date, end_date, product_id, priority, price, curr) VALUES
(3,'2020-06-15 00:00:00','2020-06-15 11:00:00', 35455, 1, 30.50, 'EUR');
INSERT INTO pricing (brand_id, start_date, end_date, product_id, priority, price, curr) VALUES
(4,'2020-06-15 16:00:00','2020-12-31 23:59:59', 35455, 1, 38.95, 'EUR');