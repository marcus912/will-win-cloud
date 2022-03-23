package org.will.win.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrderEntity extends BaseEntity {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Basic
  @Column(name = "po_number")
  private String poNumber;

  @Basic
  @Column(name = "purchase_date", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date purchaseDate;

  @Basic
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @Basic
  @Column(name = "price", nullable = false)
  private Integer price;

  @Basic
  @Column(name = "total_amount", nullable = false)
  private Integer totalAmount;

  @Basic
  @Column(name = "status", nullable = true)
  private Integer status = 1;

  @Basic
  @Column(name = "comment", nullable = true, length = -1)
  private String comment;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "purchase_customer_id", referencedColumnName = "id", nullable = false)
  private PurchaseCustomerEntity purchaseCustomerByPurchaseCustomerId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "purchase_item_id", referencedColumnName = "id", nullable = false)
  private PurchaseItemEntity purchaseItemByPurchaseItemId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
  private UnitEntity unitByUnitId;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public PurchaseCustomerEntity getPurchaseCustomerByPurchaseCustomerId() {
    return purchaseCustomerByPurchaseCustomerId;
  }

  public void setPurchaseCustomerByPurchaseCustomerId(PurchaseCustomerEntity purchaseCustomerByPurchaseCustomerId) {
    this.purchaseCustomerByPurchaseCustomerId = purchaseCustomerByPurchaseCustomerId;
  }

  public PurchaseItemEntity getPurchaseItemByPurchaseItemId() {
    return purchaseItemByPurchaseItemId;
  }

  public void setPurchaseItemByPurchaseItemId(PurchaseItemEntity purchaseItemByPurchaseItemId) {
    this.purchaseItemByPurchaseItemId = purchaseItemByPurchaseItemId;
  }

  public UnitEntity getUnitByUnitId() {
    return unitByUnitId;
  }

  public void setUnitByUnitId(UnitEntity unitByUnitId) {
    this.unitByUnitId = unitByUnitId;
  }
}
