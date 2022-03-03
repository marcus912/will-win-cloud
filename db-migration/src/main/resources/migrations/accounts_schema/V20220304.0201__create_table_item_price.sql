CREATE TABLE item_price
(
  id          INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT NOT NULL,
  material_id INT NOT NULL,
  item_id     INT NOT NULL,
  color_id    INT NOT NULL,
  price       INT NOT NULL,
  comment     TEXT,
  status      TINYINT   DEFAULT 1,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT `fk_item_price_c_id` FOREIGN KEY (`customer_id`) REFERENCES customer (`id`),
  CONSTRAINT `fk_item_price_m_id` FOREIGN KEY (`material_id`) REFERENCES material (`id`),
  CONSTRAINT `fk_item_price_i_id` FOREIGN KEY (`item_id`) REFERENCES item (`id`),
  CONSTRAINT `fk_item_price_color_id` FOREIGN KEY (`color_id`) REFERENCES color (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci;
