ALTER TABLE purchase_order
  ADD COLUMN `order_number` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL after `id`;
