package org.will.win.admin.input;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PurchaseOrderInput {

  private String poNumber;

  @NotEmpty
  private Date purchaseDate;

  @NotNull
  private Integer purchaseCustomerId;

  @NotNull
  private Integer purchaseItemId;

  @NotNull
  private Integer unitId;

  @NotNull
  private Integer quantity;

  @NotNull
  private Integer price;

  @NotNull
  private Integer totalAmount;

  private Integer status;

  private String comment;

  public String getPoNumber() {
    return poNumber;
  }

  public void setPoNumber(String poNumber) {
    this.poNumber = poNumber;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public Integer getPurchaseCustomerId() {
    return purchaseCustomerId;
  }

  public void setPurchaseCustomerId(Integer purchaseCustomerId) {
    this.purchaseCustomerId = purchaseCustomerId;
  }

  public Integer getPurchaseItemId() {
    return purchaseItemId;
  }

  public void setPurchaseItemId(Integer purchaseItemId) {
    this.purchaseItemId = purchaseItemId;
  }

  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
