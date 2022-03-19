package org.will.win.admin.model;

import org.will.win.common.model.BaseModel;
import org.will.win.persistence.entity.PurchaseOrderEntity;

import java.util.Date;
import java.util.Objects;

public class PurchaseOrder extends BaseModel {
  private Integer id;
  private String poNumber;
  private Date purchase;
  private String purchaseCustomerName;
  private String purchaseItemName;
  private String unitName;
  private Integer quantity;
  private Integer price;
  private Integer totalAmount;
  private String status;
  private String comment;

  public PurchaseOrder(Integer id,
                       String poNumber,
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
    this.poNumber = poNumber;
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
    return new PurchaseOrder(
      purchaseOrderEntity.getId(),
      purchaseOrderEntity.getPoNumber(),
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

  public String getPoNumber() {
    return poNumber;
  }

  public void setPoNumber(String poNumber) {
    this.poNumber = poNumber;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseOrder that = (PurchaseOrder) o;
    return Objects.equals(id, that.id) && Objects.equals(purchase, that.purchase) && Objects.equals(purchaseCustomerName, that.purchaseCustomerName) && Objects.equals(purchaseItemName, that.purchaseItemName) && Objects.equals(unitName, that.unitName) && Objects.equals(quantity, that.quantity) && Objects.equals(price, that.price) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(status, that.status) && Objects.equals(comment, that.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, purchase, purchaseCustomerName, purchaseItemName, unitName, quantity, price, totalAmount, status, comment);
  }

  @Override
  public String toString() {
    return "PurchaseOrder{" +
      "id=" + id +
      ", purchase=" + purchase +
      ", purchaseCustomerName='" + purchaseCustomerName + '\'' +
      ", purchaseItemName='" + purchaseItemName + '\'' +
      ", unitName='" + unitName + '\'' +
      ", quantity=" + quantity +
      ", price=" + price +
      ", totalAmount=" + totalAmount +
      ", status='" + status + '\'' +
      ", comment='" + comment + '\'' +
      ", createdAt=" + createdAt +
      ", modifiedAt=" + modifiedAt +
      ", createdBy='" + createdBy + '\'' +
      ", updatedBy='" + updatedBy + '\'' +
      '}';
  }
}
