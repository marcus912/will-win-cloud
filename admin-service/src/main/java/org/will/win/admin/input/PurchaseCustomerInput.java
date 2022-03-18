package org.will.win.admin.input;

import javax.validation.constraints.NotEmpty;

public class PurchaseCustomerInput {

  @NotEmpty(message = "Name may not be empty")
  private String name;

  private String address;

  private String fax;

  private String tel;

  private String contact;

  private String contactPhone;

  private String contactEmail;

  private Integer taxIdNumber;

  private String comment;

  private Integer status;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public Integer getTaxIdNumber() {
    return taxIdNumber;
  }

  public void setTaxIdNumber(Integer taxIdNumber) {
    this.taxIdNumber = taxIdNumber;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
