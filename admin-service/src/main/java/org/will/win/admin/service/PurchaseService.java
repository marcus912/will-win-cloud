package org.will.win.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.will.win.admin.input.PurchaseCustomerInput;
import org.will.win.admin.input.PurchaseItemInput;
import org.will.win.admin.input.PurchaseOrderInput;
import org.will.win.admin.model.PurchaseCustomer;
import org.will.win.admin.model.PurchaseItem;
import org.will.win.admin.model.PurchaseOrder;
import org.will.win.persistence.entity.PurchaseCustomerEntity;
import org.will.win.persistence.entity.PurchaseItemEntity;
import org.will.win.persistence.entity.PurchaseOrderEntity;
import org.will.win.persistence.entity.UnitEntity;
import org.will.win.persistence.repository.PurchaseCustomerRepository;
import org.will.win.persistence.repository.PurchaseItemRepository;
import org.will.win.persistence.repository.PurchaseOrderRepository;
import org.will.win.persistence.repository.UnitRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PurchaseService {
  final private PurchaseItemRepository purchaseItemRepository;
  final private PurchaseCustomerRepository purchaseCustomerRepository;
  final private PurchaseOrderRepository purchaseOrderRepository;
  final private UnitRepository unitRepository;

  @Autowired
  public PurchaseService(PurchaseItemRepository purchaseItemRepository,
                         PurchaseCustomerRepository purchaseCustomerRepository,
                         PurchaseOrderRepository purchaseOrderRepository,
                         UnitRepository unitRepository) {
    this.purchaseItemRepository = purchaseItemRepository;
    this.purchaseCustomerRepository = purchaseCustomerRepository;
    this.purchaseOrderRepository = purchaseOrderRepository;
    this.unitRepository = unitRepository;
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

  public void deletePurchaseItem(int id) {
    PurchaseItemEntity entity = purchaseItemRepository.findById(id).get();
    // TODO else throw resource not found exception.
    if (Objects.nonNull(entity)) {
      purchaseItemRepository.delete(entity);
    }
  }

  // =========================== Order ===========================

  public PurchaseOrder addPurchaseOrder(PurchaseOrderInput input) {
    PurchaseOrderEntity entity = new PurchaseOrderEntity();
    syncPurchaseOrderData(input, entity);
    return PurchaseOrder.of(purchaseOrderRepository.save(entity));
  }

  @Transactional(readOnly = true)
  public List<PurchaseOrder> searchPurchaseOrders(Pageable pageable) {
    return purchaseOrderRepository.findAll().stream()
      .map(e -> PurchaseOrder.of(e))
      .collect(Collectors.toList());
  }

  public PurchaseOrder editPurchaseOrder(PurchaseOrderInput input, int id) {
    PurchaseOrderEntity entity = purchaseOrderRepository.findById(id).get();
    // TODO else throw resource not found exception.
    if (Objects.nonNull(entity)) {
      syncPurchaseOrderData(input, entity);
      return PurchaseOrder.of(purchaseOrderRepository.save(entity));
    }
    return null;
  }

  private void syncPurchaseOrderData(PurchaseOrderInput input,
                                     PurchaseOrderEntity entity) {
    PurchaseItemEntity item = purchaseItemRepository.findById(input.getPurchaseItemId()).get();
    PurchaseCustomerEntity customer = purchaseCustomerRepository.findById(input.getPurchaseCustomerId()).get();
    UnitEntity unit = unitRepository.findById(input.getUnitId()).get();
    entity.setPurchaseDate(input.getPurchaseDate());
    entity.setPurchaseCustomerByPurchaseCustomerId(customer);
    entity.setPurchaseItemByPurchaseItemId(item);
    entity.setUnitByUnitId(unit);
    entity.setQuantity(input.getQuantity());
    entity.setPrice(input.getPrice());
    entity.setTotalAmount(input.getTotalAmount());
//    if (Objects.nonNull(input.getStatus())) {
//      entity.setStatus(input.getStatus());
//    }
  }

  public void deletePurchaseOrder(int id) {
    PurchaseOrderEntity entity = purchaseOrderRepository.findById(id).get();
    // TODO else throw resource not found exception.
    if (Objects.nonNull(entity)) {
      purchaseOrderRepository.delete(entity);
    }
  }

  // =========================== Customer ===========================

  public PurchaseCustomer addPurchaseCustomer(PurchaseCustomerInput input) {
    PurchaseCustomerEntity entity = new PurchaseCustomerEntity();
    syncPurchaseCustomerData(input, entity);
    return PurchaseCustomer.of(purchaseCustomerRepository.save(entity));
  }

  @Transactional(readOnly = true)
  public List<PurchaseCustomer> searchPurchaseCustomers(Pageable pageable) {
    return purchaseCustomerRepository.findAll().stream()
      .map(e -> PurchaseCustomer.of(e))
      .collect(Collectors.toList());
  }

  public PurchaseCustomer editPurchaseCustomer(PurchaseCustomerInput input, int id) {
    PurchaseCustomerEntity entity = purchaseCustomerRepository.findById(id).get();
    // TODO else throw resource not found exception.
    if (Objects.nonNull(entity)) {
      syncPurchaseCustomerData(input, entity);
      return PurchaseCustomer.of(purchaseCustomerRepository.save(entity));
    }
    return null;
  }

  private void syncPurchaseCustomerData(PurchaseCustomerInput input,
                                        PurchaseCustomerEntity entity) {
    input.setName(entity.getName());
    input.setAddress(entity.getAddress());
    input.setFax(entity.getFax());
    input.setTel(entity.getTel());
    input.setContact(entity.getContact());
    input.setContactPhone(entity.getContactPhone());
    input.setContactEmail(entity.getContactEmail());
    input.setTaxIdNumber(entity.getTaxIdNumber());
    input.setComment(entity.getComment());
//    if (Objects.nonNull(input.getStatus())) {
//      entity.setStatus(input.getStatus());
//    }
  }

  public void deletePurchaseCustomer(int id) {
    PurchaseCustomerEntity entity = purchaseCustomerRepository.findById(id).get();
    // TODO else throw resource not found exception.
    if (Objects.nonNull(entity)) {
      purchaseCustomerRepository.delete(entity);
    }
  }
}

