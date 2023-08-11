CREATE TABLE sales_order
(
  id           INT AUTO_INCREMENT PRIMARY KEY,
  orders_date  DATE        NOT NULL,
  so_number    VARCHAR(60) NOT NULL UNIQUE KEY,
  customer_id  INT         NOT NULL,
  item_id      INT         NOT NULL,
  unit_id      INT         NOT NULL,
  quantity     MEDIUMINT   NOT NULL,
  price        INT         NOT NULL,
  total_amount INT         NOT NULL,
  invoice      VARCHAR(60),
  status       TINYINT     NOT NULL DEFAULT 1,
  comment      TEXT,
  created_at   TIMESTAMP            DEFAULT CURRENT_TIMESTAMP,
  modified_at  TIMESTAMP          DEFAULT CURRENT_TIMESTAMP,
  created_by   VARCHAR(256)       DEFAULT NULL,
  updated_by   VARCHAR(256)       DEFAULT NULL,
  CONSTRAINT `fk_sales_order_sc_id` FOREIGN KEY (`customer_id`) REFERENCES customer (`id`),
  CONSTRAINT `fk_sales_order_si_id` FOREIGN KEY (`item_id`) REFERENCES item (`id`),
  CONSTRAINT `fk_sales_order_unit_id` FOREIGN KEY (`unit_id`) REFERENCES unit (`id`)
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_unicode_520_ci;

