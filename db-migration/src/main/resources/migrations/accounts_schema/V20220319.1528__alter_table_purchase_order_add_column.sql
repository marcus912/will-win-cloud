ALTER TABLE purchase_order
  ADD COLUMN `purchase_order_number` varchar(60) COLLATE utf8mb4_unicode_520_ci NOT NULL after `id`;
