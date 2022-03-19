ALTER TABLE purchase_order
  ADD COLUMN `po_number` MEDIUMINT NOT NULL after `id`;

alter table purchase_order
  add UNIQUE KEY `po_number_purchase_date_uk` (`po_number`, `purchase_date`);
