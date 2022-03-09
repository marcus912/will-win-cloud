package org.will.win.admin.input;

import javax.validation.constraints.NotEmpty;

public class PurchaseItemInput {

  @NotEmpty(message = "Name may not be empty")
  private String name;

  private String comment;

  private Boolean status;

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
}
