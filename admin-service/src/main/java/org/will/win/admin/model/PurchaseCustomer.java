package org.will.win.admin.model;

import org.will.win.common.model.BaseModel;
import org.will.win.persistence.entity.PurchaseCustomerEntity;

import java.util.Date;
import java.util.Objects;

public class PurchaseCustomer extends BaseModel {

  private Integer id;
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

  public PurchaseCustomer(Integer id,
                          String name,
                          String address,
                          String fax,
                          String tel,
                          String contact,
                          String contactPhone,
                          String contactEmail,
                          Integer taxIdNumber,
                          String comment,
                          Integer status,
                          Date createdAt,
                          Date modifiedAt,
                          String createdBy,
                          String updatedBy) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.fax = fax;
    this.tel = tel;
    this.contact = contact;
    this.contactPhone = contactPhone;
    this.contactEmail = contactEmail;
    this.taxIdNumber = taxIdNumber;
    this.comment = comment;
    this.status = status;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public static PurchaseCustomer of(PurchaseCustomerEntity entity) {
    return new PurchaseCustomer(
      entity.getId(),
      entity.getName(),
      entity.getAddress(),
      entity.getFax(),
      entity.getTel(),
      entity.getContact(),
      entity.getContactPhone(),
      entity.getContactEmail(),
      entity.getTaxIdNumber(),
      entity.getComment(),
      entity.getStatus(),
      entity.getCreatedAt(),
      entity.getModifiedAt(),
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseCustomer that = (PurchaseCustomer) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(fax, that.fax) && Objects.equals(tel, that.tel) && Objects.equals(contact, that.contact) && Objects.equals(contactPhone, that.contactPhone) && Objects.equals(contactEmail, that.contactEmail) && Objects.equals(taxIdNumber, that.taxIdNumber) && Objects.equals(comment, that.comment) && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, fax, tel, contact, contactPhone, contactEmail, taxIdNumber, comment, status);
  }

  @Override
  public String toString() {
    return "PurchaseCustomer{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", address='" + address + '\'' +
      ", fax='" + fax + '\'' +
      ", tel='" + tel + '\'' +
      ", contact='" + contact + '\'' +
      ", contactPhone='" + contactPhone + '\'' +
      ", contactEmail='" + contactEmail + '\'' +
      ", taxIdNumber='" + taxIdNumber + '\'' +
      ", comment='" + comment + '\'' +
      ", status=" + status +
      ", createdAt=" + createdAt +
      ", modifiedAt=" + modifiedAt +
      ", createdBy='" + createdBy + '\'' +
      ", updatedBy='" + updatedBy + '\'' +
      '}';
  }
}
