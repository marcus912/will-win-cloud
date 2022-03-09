CREATE TABLE purchase_order
(
  id                   INT AUTO_INCREMENT PRIMARY KEY,
  purchase_date        DATE      NOT NULL,
  purchase_customer_id INT       NOT NULL,
  purchase_item_id     INT       NOT NULL,
  unit_id              INT       NOT NULL,
  quantity             MEDIUMINT NOT NULL,
  price                INT       NOT NULL,
  total_amount         INT       NOT NULL,
  status               TINYINT   NOT NULL DEFAULT 1,
  comment              TEXT,
  created_at           TIMESTAMP          DEFAULT CURRENT_TIMESTAMP,
  modified_at          TIMESTAMP          DEFAULT CURRENT_TIMESTAMP,
  created_by           VARCHAR(256)       DEFAULT NULL,
  updated_by           VARCHAR(256)       DEFAULT NULL,
  CONSTRAINT `fk_purchase_order_pc_id` FOREIGN KEY (`purchase_customer_id`) REFERENCES purchase_customer (`id`),
  CONSTRAINT `fk_purchase_order_pi_id` FOREIGN KEY (`purchase_item_id`) REFERENCES purchase_item (`id`),
  CONSTRAINT `fk_purchase_order_unit_id` FOREIGN KEY (`unit_id`) REFERENCES unit (`id`)
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_unicode_520_ci;

