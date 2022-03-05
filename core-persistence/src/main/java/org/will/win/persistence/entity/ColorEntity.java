package org.will.win.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "color")
public class ColorEntity extends BaseEntity {
  private int id;
  private String code;
  private String name;
  private String nameEng;
  private Byte status;
  private String comment;
  private Collection<ItemPriceEntity> itemPricesById;

  @Id
  @Column(name = "id", nullable = false)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "code", nullable = false, length = 60)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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
  @Column(name = "name_eng", nullable = true, length = 255)
  public String getNameEng() {
    return nameEng;
  }

  public void setNameEng(String nameEng) {
    this.nameEng = nameEng;
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
    ColorEntity that = (ColorEntity) o;
    return id == that.id && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(nameEng, that.nameEng) && Objects.equals(status, that.status) && Objects.equals(comment, that.comment) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, name, nameEng, status, comment, createdAt, modifiedAt);
  }

  @OneToMany(mappedBy = "colorByColorId", fetch = FetchType.LAZY)
  public Collection<ItemPriceEntity> getItemPricesById() {
    return itemPricesById;
  }

  public void setItemPricesById(Collection<ItemPriceEntity> itemPricesById) {
    this.itemPricesById = itemPricesById;
  }
}
