package org.will.win.admin.model;

import org.will.win.common.model.BaseModel;
import org.will.win.persistence.entity.PurchaseItemEntity;

import java.util.Date;
import java.util.Objects;

public class PurchaseItem extends BaseModel {

  private Integer id;
  private String name;
  private String comment;
  private Boolean status;

  public PurchaseItem(Integer id, String name, String comment, Boolean status, Date createdAt, Date modifiedAt, String createdBy, String updatedBy) {
    this.id = id;
    this.name = name;
    this.comment = comment;
    this.status = status;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public static PurchaseItem of(PurchaseItemEntity entity) {
    return new PurchaseItem(entity.getId(), entity.getName(), entity.getComment(), entity.getStatus(),
      new Date(entity.getCreatedAt().getTime()),
      new Date(entity.getModifiedAt().getTime()),
      entity.getCreatedBy(),
      entity.getUpdatedBy()
    );
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseItem that = (PurchaseItem) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(comment, that.comment) && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, comment, status);
  }

  @Override
  public String toString() {
    return "PurchaseItem{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", comment='" + comment + '\'' +
      ", status=" + status +
      ", createdAt=" + createdAt +
      ", modifiedAt=" + modifiedAt +
      ", createdBy='" + createdBy + '\'' +
      ", updatedBy='" + updatedBy + '\'' +
      '}';
  }
}
