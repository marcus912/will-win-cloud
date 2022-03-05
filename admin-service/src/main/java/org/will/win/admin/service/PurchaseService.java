package org.will.win.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.will.win.persistence.repository.PurchaseCustomerRepository;
import org.will.win.persistence.repository.PurchaseItemRepository;
import org.will.win.persistence.repository.PurchaseOrderRepository;

@Service
public class PurchaseService {
  private PurchaseItemRepository purchaseItemRepository;
  private PurchaseCustomerRepository purchaseCustomerRepository;
  private PurchaseOrderRepository purchaseOrderRepository;

  @Autowired
  public PurchaseService(PurchaseItemRepository purchaseItemRepository, PurchaseCustomerRepository purchaseCustomerRepository, PurchaseOrderRepository purchaseOrderRepository) {
    this.purchaseItemRepository = purchaseItemRepository;
    this.purchaseCustomerRepository = purchaseCustomerRepository;
    this.purchaseOrderRepository = purchaseOrderRepository;
  }
}
