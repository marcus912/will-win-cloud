CREATE TABLE purchase_customer
(
  id            INT AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(100) NOT NULL UNIQUE KEY,
  address       VARCHAR(255),
  fax           VARCHAR(255),
  tel           VARCHAR(255),
  contact       VARCHAR(255),
  contact_phone VARCHAR(255),
  contact_email VARCHAR(255),
  tax_id_number INT,
  comment       TEXT,
  status        TINYINT      DEFAULT 1,
  created_at    TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
  modified_at   TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
  created_by    VARCHAR(256) DEFAULT NULL,
  updated_by    VARCHAR(256) DEFAULT NULL
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_unicode_520_ci;
