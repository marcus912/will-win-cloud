CREATE TABLE color
(
  id          INT AUTO_INCREMENT PRIMARY KEY,
  code        VARCHAR(60)  NOT NULL UNIQUE KEY,
  name        VARCHAR(255) NOT NULL,
  name_eng    VARCHAR(255),
  status      TINYINT      NOT NULL DEFAULT 1,
  comment     TEXT,
  created_at  TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  modified_at TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  created_by  VARCHAR(256)          DEFAULT NULL,
  updated_by  VARCHAR(256)          DEFAULT NULL
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_unicode_520_ci;

