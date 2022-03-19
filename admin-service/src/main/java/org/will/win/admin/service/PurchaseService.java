package org.will.win.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.will.win.common.exception.PurchaseCustomerNotFoundException;
import org.will.win.common.exception.PurchaseItemNotFoundException;
import org.will.win.common.exception.PurchaseOrderNotFoundException;
import org.will.win.common.exception.UnitNotFoundException;
import org.will.win.common.utils.WillWinUtils;
import org.will.win.persistence.entity.PurchaseCustomerEntity;
import org.will.win.persistence.entity.PurchaseItemEntity;
import org.will.win.persistence.entity.PurchaseOrderEntity;
import org.will.win.persistence.entity.UnitEntity;
import org.will.win.persistence.repository.PurchaseCustomerRepository;
import org.will.win.persistence.repository.PurchaseItemRepository;
import org.will.win.persistence.repository.PurchaseOrderRepository;
import org.will.win.persistence.repository.UnitRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PurchaseService {
  static Logger logger = LoggerFactory.getLogger(PurchaseService.class.getName());

  final private WillWinUtils willWinUtils;
  final private PurchaseItemRepository purchaseItemRepository;
  final private PurchaseCustomerRepository purchaseCustomerRepository;
  final private PurchaseOrderRepository purchaseOrderRepository;
  final private UnitRepository unitRepository;

  @Autowired
  public PurchaseService(
    WillWinUtils willWinUtils,
    PurchaseItemRepository purchaseItemRepository,
    PurchaseCustomerRepository purchaseCustomerRepository,
    PurchaseOrderRepository purchaseOrderRepository,
    UnitRepository unitRepository) {
    this.willWinUtils = willWinUtils;
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
    PurchaseItemEntity entity = purchaseItemRepository.findById(id)
      .orElseThrow(() -> new PurchaseItemNotFoundException(id));
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
    PurchaseItemEntity entity = purchaseItemRepository.findById(id)
      .orElseThrow(() -> new PurchaseItemNotFoundException(id));
    purchaseItemRepository.delete(entity);
  }

  // =========================== Order ===========================

  public PurchaseOrder addPurchaseOrder(PurchaseOrderInput input) {
    PurchaseOrderEntity entity = new PurchaseOrderEntity();
    syncPurchaseOrderData(input, entity);
    return PurchaseOrder.of(purchaseOrderRepository.save(entity));
  }

  /**
   * Find a new PoNumber which is belonged to this purchase date.
   *
   * @return PoNumber
   */
  private int getNewPoNumber(Date purchaseDate) {
    int poNumber;
    boolean isPresent;
    do {
      poNumber = willWinUtils.generatePoNumber();
      isPresent = purchaseOrderRepository.findByPurchaseDateAndPoNumber(purchaseDate, poNumber).isPresent();
      if (isPresent) {
        logger.info("PoNumber is present, generate another one. PoNumber {}",
          String.format("%d", poNumber));
      }
    } while (isPresent);
    return poNumber;
  }

  @Transactional(readOnly = true)
  public List<PurchaseOrder> searchPurchaseOrders(Pageable pageable) {
    return purchaseOrderRepository.findAll().stream()
      .map(PurchaseOrder::of)
      .collect(Collectors.toList());
  }

  public PurchaseOrder editPurchaseOrder(PurchaseOrderInput input, int id) {
    PurchaseOrderEntity entity = purchaseOrderRepository.findById(id)
      .orElseThrow(() -> new PurchaseOrderNotFoundException(id));
    syncPurchaseOrderData(input, entity);
    return PurchaseOrder.of(purchaseOrderRepository.save(entity));
  }

  private void syncPurchaseOrderData(PurchaseOrderInput input,
                                     PurchaseOrderEntity entity) {
    PurchaseItemEntity item = purchaseItemRepository.findById(input.getPurchaseItemId())
      .orElseThrow(() -> new PurchaseItemNotFoundException(input.getPurchaseItemId()));
    PurchaseCustomerEntity customer = purchaseCustomerRepository.findById(input.getPurchaseCustomerId())
      .orElseThrow(() -> new PurchaseCustomerNotFoundException(input.getPurchaseCustomerId()));
    UnitEntity unit = unitRepository.findById(input.getUnitId())
      .orElseThrow(() -> new UnitNotFoundException(input.getUnitId()));
    entity.setPoNumber(input.getPoNumber());
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
    PurchaseOrderEntity entity = purchaseOrderRepository.findById(id)
      .orElseThrow(() -> new PurchaseOrderNotFoundException(id));
    purchaseOrderRepository.delete(entity);
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
      .map(PurchaseCustomer::of)
      .collect(Collectors.toList());
  }

  public PurchaseCustomer editPurchaseCustomer(PurchaseCustomerInput input, int id) {
    PurchaseCustomerEntity entity = purchaseCustomerRepository.findById(id)
      .orElseThrow(() -> new PurchaseCustomerNotFoundException(id));
    syncPurchaseCustomerData(input, entity);
    return PurchaseCustomer.of(purchaseCustomerRepository.save(entity));
  }

  private void syncPurchaseCustomerData(PurchaseCustomerInput input,
                                        PurchaseCustomerEntity entity) {
    entity.setName(input.getName());
    entity.setAddress(input.getAddress());
    entity.setFax(input.getFax());
    entity.setTel(input.getTel());
    entity.setContact(input.getContact());
    entity.setContactPhone(input.getContactPhone());
    entity.setContactEmail(input.getContactEmail());
    entity.setTaxIdNumber(input.getTaxIdNumber());
    entity.setComment(input.getComment());
//    if (Objects.nonNull(input.getStatus())) {
//      entity.setStatus(input.getStatus());
//    }
  }

  public void deletePurchaseCustomer(int id) {
    PurchaseCustomerEntity entity = purchaseCustomerRepository.findById(id)
      .orElseThrow(() -> new PurchaseCustomerNotFoundException(id));
    purchaseCustomerRepository.delete(entity);
  }
}

