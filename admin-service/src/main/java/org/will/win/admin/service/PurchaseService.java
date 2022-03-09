package org.will.win.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.will.win.admin.input.PurchaseItemInput;
import org.will.win.admin.model.PurchaseItem;
import org.will.win.persistence.entity.PurchaseItemEntity;
import org.will.win.persistence.repository.PurchaseCustomerRepository;
import org.will.win.persistence.repository.PurchaseItemRepository;
import org.will.win.persistence.repository.PurchaseOrderRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PurchaseService {
  final private PurchaseItemRepository purchaseItemRepository;
  final private PurchaseCustomerRepository purchaseCustomerRepository;
  final private PurchaseOrderRepository purchaseOrderRepository;

  @Autowired
  public PurchaseService(PurchaseItemRepository purchaseItemRepository, PurchaseCustomerRepository purchaseCustomerRepository, PurchaseOrderRepository purchaseOrderRepository) {
    this.purchaseItemRepository = purchaseItemRepository;
    this.purchaseCustomerRepository = purchaseCustomerRepository;
    this.purchaseOrderRepository = purchaseOrderRepository;
  }

  public PurchaseItem addPurchaseItem(PurchaseItemInput input) {
    PurchaseItemEntity entity = new PurchaseItemEntity();
    entity.setName(input.getName());
    entity.setComment(input.getComment());
    return PurchaseItem.of(purchaseItemRepository.save(entity));
  }

  @Transactional(readOnly = true)
  public List<PurchaseItem> searchPurchaseItems(Pageable pageable) {
    List<PurchaseItem> list;
    try (Stream<PurchaseItemEntity> stream = purchaseItemRepository.searchPurchaseItem()) {
      list = stream.map(PurchaseItem::of).collect(Collectors.toList());
    }
    return list;
  }

  public PurchaseItem editPurchaseItem(PurchaseItemInput input, int id) {
    PurchaseItemEntity entity = purchaseItemRepository.findById(id).get();
    // TODO else throw resource not found exception.
    if (Objects.nonNull(entity)) {
      entity.setName(input.getName());
      entity.setComment(input.getComment());
      if (Objects.nonNull(input.getStatus())) {
        entity.setStatus(input.getStatus());
      }
      return PurchaseItem.of(purchaseItemRepository.save(entity));
    }
    return null;
  }
}

