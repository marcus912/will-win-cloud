package org.will.win.admin.model;

import org.will.win.persistence.entity.PurchaseItemEntity;

import java.sql.Timestamp;

public class PurchaseItem {

  private String name;
  private String comment;
  private Boolean status;
  private Timestamp createdAt;
  private Timestamp modifiedAt;
  private String createdBy;
  private String updatedBy;

  public PurchaseItem(String name, String comment, Boolean status) {
    this.name = name;
    this.comment = comment;
    this.status = status;
  }

  public static PurchaseItem of(PurchaseItemEntity entity) {
    return new PurchaseItem(entity.getName(), entity.getComment(), entity.getStatus());
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

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Timestamp modifiedAt) {
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
