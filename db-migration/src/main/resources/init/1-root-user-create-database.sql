CREATE
  DATABASE willwin CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci;
CREATE
  USER 'willwin'@'%' IDENTIFIED BY 'willwin';
GRANT ALL PRIVILEGES ON willwin.* to
  'willwin'@'%';
