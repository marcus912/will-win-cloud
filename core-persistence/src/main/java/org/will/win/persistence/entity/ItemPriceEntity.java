package org.will.win.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_price")
public class ItemPriceEntity extends BaseEntity {
  private int id;
  private int price;
  private String comment;
  private Byte status;
  private CustomerEntity customerByCustomerId;
  private MaterialEntity materialByMaterialId;
  private ItemEntity itemByItemId;
  private ColorEntity colorByColorId;

  @Id
  @Column(name = "id", nullable = false)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
  @Column(name = "comment", nullable = true, length = -1)
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Basic
  @Column(name = "status", nullable = true)
  public Byte getStatus() {
    return status;
  }

  public void setStatus(Byte status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemPriceEntity that = (ItemPriceEntity) o;
    return id == that.id && price == that.price && Objects.equals(comment, that.comment) && Objects.equals(status, that.status) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price, comment, status, createdAt, modifiedAt);
  }

  @ManyToOne
  @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
  public CustomerEntity getCustomerByCustomerId() {
    return customerByCustomerId;
  }

  public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
    this.customerByCustomerId = customerByCustomerId;
  }

  @ManyToOne
  @JoinColumn(name = "material_id", referencedColumnName = "id", nullable = false)
  public MaterialEntity getMaterialByMaterialId() {
    return materialByMaterialId;
  }

  public void setMaterialByMaterialId(MaterialEntity materialByMaterialId) {
    this.materialByMaterialId = materialByMaterialId;
  }

  @ManyToOne
  @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
  public ItemEntity getItemByItemId() {
    return itemByItemId;
  }

  public void setItemByItemId(ItemEntity itemByItemId) {
    this.itemByItemId = itemByItemId;
  }

  @ManyToOne
  @JoinColumn(name = "color_id", referencedColumnName = "id", nullable = false)
  public ColorEntity getColorByColorId() {
    return colorByColorId;
  }

  public void setColorByColorId(ColorEntity colorByColorId) {
    this.colorByColorId = colorByColorId;
  }
}
