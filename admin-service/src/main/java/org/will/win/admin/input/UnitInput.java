package org.will.win.admin.input;

import javax.validation.constraints.NotEmpty;

public class UnitInput {
  private String name;
  private Boolean status;
  private String comment;

  @NotEmpty(message = "Unit name cannot be empty")
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
}
