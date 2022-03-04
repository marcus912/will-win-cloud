package org.will.win.persistence.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrderEntity {
  private int id;
  private Date purchaseDate;
  private Object quantity;
  private int price;
  private int totalAmount;
  private Byte status;
  private String comment;
  private Timestamp createdAt;
  private Timestamp modifiedAt;

  @Id
  @Column(name = "id", nullable = false)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "purchase_date", nullable = false)
  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  @Basic
  @Column(name = "quantity", nullable = false)
  public Object getQuantity() {
    return quantity;
  }

  public void setQuantity(Object quantity) {
    this.quantity = quantity;
  }

  @Basic
  @Column(name = "price", nullable = false)
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Basic
  @Column(name = "total_amount", nullable = false)
  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Basic
  @Column(name = "status", nullable = true)
  public Byte getStatus() {
    return status;
  }

  public void setStatus(Byte status) {
    this.status = status;
  }

  @Basic
  @Column(name = "comment", nullable = true, length = -1)
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Basic
  @Column(name = "created_at", nullable = false)
  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  @Basic
  @Column(name = "modified_at", nullable = false)
  public Timestamp getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Timestamp modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseOrderEntity that = (PurchaseOrderEntity) o;
    return id == that.id && price == that.price && totalAmount == that.totalAmount && Objects.equals(purchaseDate, that.purchaseDate) && Objects.equals(quantity, that.quantity) && Objects.equals(status, that.status) && Objects.equals(comment, that.comment) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, purchaseDate, quantity, price, totalAmount, status, comment, createdAt, modifiedAt);
  }
}
