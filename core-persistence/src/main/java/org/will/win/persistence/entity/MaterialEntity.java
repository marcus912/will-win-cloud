package org.will.win.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "material")
public class MaterialEntity extends BaseEntity {
  private int id;
  private String name;
  private Byte status;
  private String comment;
  private Collection<ItemPriceEntity> itemPricesById;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name", nullable = false, length = 255)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MaterialEntity that = (MaterialEntity) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(comment, that.comment) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, comment, createdAt, modifiedAt);
  }

  @OneToMany(mappedBy = "materialByMaterialId", fetch = FetchType.LAZY)
  public Collection<ItemPriceEntity> getItemPricesById() {
    return itemPricesById;
  }

  public void setItemPricesById(Collection<ItemPriceEntity> itemPricesById) {
    this.itemPricesById = itemPricesById;
  }
}
