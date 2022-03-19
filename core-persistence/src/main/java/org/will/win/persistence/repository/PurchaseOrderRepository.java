package org.will.win.persistence.repository;

import org.will.win.persistence.entity.PurchaseOrderEntity;

import java.util.Date;
import java.util.Optional;

public interface PurchaseOrderRepository extends BaseRepository<PurchaseOrderEntity, Integer> {
  Optional<PurchaseOrderEntity> findByPurchaseDateAndPoNumber(Date purchaseDate, int poNumber);
}
