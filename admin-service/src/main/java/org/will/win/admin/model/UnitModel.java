package org.will.win.admin.model;

import org.will.win.common.model.BaseModel;
import org.will.win.persistence.entity.UnitEntity;

import java.util.Date;
import java.util.Objects;

public class UnitModel extends BaseModel {
  private String name;
  private Boolean status;
  private String comment;

  public UnitModel(String name,
                   Boolean status,
                   String comment,
                   Date createdAt,
                   Date modifiedAt,
                   String createdBy,
                   String updatedBy) {
    this.name = name;
    this.status = status;
    this.comment = comment;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public static UnitModel of(UnitEntity entity) {
    return new UnitModel(entity.getName(),
      entity.getStatus(),
      entity.getComment(),
      entity.getCreatedAt(),
      entity.getModifiedAt(),
      entity.getCreatedBy(),
      entity.getUpdatedBy());
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
    UnitModel unitModel = (UnitModel) o;
    return Objects.equals(name, unitModel.name) && Objects.equals(status, unitModel.status) && Objects.equals(comment, unitModel.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, status, comment);
  }

  @Override
  public String toString() {
    return "UnitModel{" +
      "name='" + name + '\'' +
      ", status='" + status + '\'' +
      ", comment='" + comment + '\'' +
      ", createdAt=" + createdAt +
      ", modifiedAt=" + modifiedAt +
      ", createdBy='" + createdBy + '\'' +
      ", updatedBy='" + updatedBy + '\'' +
      '}';
  }
}
