package org.will.win.admin.model;

import org.will.win.persistence.entity.PurchaseOrderEntity;

import java.util.Date;

public class PurchaseOrder {
  private Integer id;
  private Date purchase;
  private String purchaseCustomerName;
  private String purchaseItemName;
  private String unitName;
  private Integer quantity;
  private Integer price;
  private Integer totalAmount;
  private String status;
  private String comment;
  private Date createdAt;
  private Date modifiedAt;
  private String createdBy;
  private String updatedBy;

  public PurchaseOrder(Integer id,
                       Date purchase,
                       String purchaseCustomerName,
                       String purchaseItemName,
                       String unitName,
                       Integer quantity,
                       Integer price,
                       Integer totalAmount,
                       String status, String comment,
                       Date createdAt,
                       Date modifiedAt,
                       String createdBy,
                       String updatedBy) {
    this.id = id;
    this.purchase = purchase;
    this.purchaseCustomerName = purchaseCustomerName;
    this.purchaseItemName = purchaseItemName;
    this.unitName = unitName;
    this.quantity = quantity;
    this.price = price;
    this.totalAmount = totalAmount;
    this.status = status;
    this.comment = comment;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public static PurchaseOrder of(PurchaseOrderEntity purchaseOrderEntity) {
    return new PurchaseOrder(purchaseOrderEntity.getId(),
      purchaseOrderEntity.getPurchaseDate(),
      purchaseOrderEntity.getPurchaseCustomerByPurchaseCustomerId().getName(),
      purchaseOrderEntity.getPurchaseItemByPurchaseItemId().getName(),
      purchaseOrderEntity.getUnitByUnitId().getName(),
      purchaseOrderEntity.getQuantity(),
      purchaseOrderEntity.getPrice(),
      purchaseOrderEntity.getTotalAmount(),
      purchaseOrderEntity.getStatus().toString(),
      purchaseOrderEntity.getComment(),
      purchaseOrderEntity.getCreatedAt(),
      purchaseOrderEntity.getModifiedAt(),
      purchaseOrderEntity.getCreatedBy(),
      purchaseOrderEntity.getUpdatedBy()
    );
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getPurchase() {
    return purchase;
  }

  public void setPurchase(Date purchase) {
    this.purchase = purchase;
  }

  public String getPurchaseCustomerName() {
    return purchaseCustomerName;
  }

  public void setPurchaseCustomerName(String purchaseCustomerName) {
    this.purchaseCustomerName = purchaseCustomerName;
  }

  public String getPurchaseItemName() {
    return purchaseItemName;
  }

  public void setPurchaseItemName(String purchaseItemName) {
    this.purchaseItemName = purchaseItemName;
  }

  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }
}
