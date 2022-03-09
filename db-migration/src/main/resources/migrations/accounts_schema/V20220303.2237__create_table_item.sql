CREATE TABLE item
(
  id          INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(255) NOT NULL,
  status      TINYINT      NOT NULL DEFAULT 1,
  comment     TEXT,
  created_at  TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  modified_at TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  created_by  VARCHAR(256)          DEFAULT NULL,
  updated_by  VARCHAR(256)          DEFAULT NULL
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_unicode_520_ci;
