package org.will.win.admin.model;

import org.will.win.persistence.entity.PurchaseItemEntity;

import java.util.Date;

public class PurchaseItem {

  private Integer id;
  private String name;
  private String comment;
  private Boolean status;
  private Date createdAt;
  private Date modifiedAt;
  private String createdBy;
  private String updatedBy;

  public PurchaseItem(Integer id, String name, String comment, Boolean status) {
    this.id = id;
    this.name = name;
    this.comment = comment;
    this.status = status;
  }

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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
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
