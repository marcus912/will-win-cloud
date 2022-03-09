package org.will.win.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "purchase_item")
public class PurchaseItemEntity extends BaseEntity {
  @Id
  @Column(name = "id", nullable = false)
  private int id;

  @Basic
  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Basic
  @Column(name = "status", nullable = true, insertable = false, updatable = false)
  private Boolean status;

  private String comment;

  @OneToMany(mappedBy = "purchaseItemByPurchaseItemId", fetch = FetchType.LAZY)
  private Collection<PurchaseOrderEntity> purchaseOrdersById;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseItemEntity that = (PurchaseItemEntity) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(comment, that.comment) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, comment, createdAt, modifiedAt);
  }

  public Collection<PurchaseOrderEntity> getPurchaseOrdersById() {
    return purchaseOrdersById;
  }

  public void setPurchaseOrdersById(Collection<PurchaseOrderEntity> purchaseOrdersById) {
    this.purchaseOrdersById = purchaseOrdersById;
  }
}
