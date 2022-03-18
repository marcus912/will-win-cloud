package org.will.win.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "purchase_customer")
public class PurchaseCustomerEntity extends BaseEntity {

  @Id
  @Column(name = "id", nullable = false)
  private int id;

  @Basic
  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Basic
  @Column(name = "address", nullable = true, length = 255)
  private String address;

  @Basic
  @Column(name = "fax", nullable = true, length = 255)
  private String fax;

  @Basic
  @Column(name = "tel", nullable = true, length = 255)
  private String tel;

  @Basic
  @Column(name = "contact", nullable = true, length = 255)
  private String contact;

  @Basic
  @Column(name = "contact_phone", nullable = true, length = 255)
  private String contactPhone;

  @Basic
  @Column(name = "contact_email", nullable = true, length = 255)
  private String contactEmail;

  @Basic
  @Column(name = "tax_id_number", nullable = true)
  private Integer taxIdNumber;

  @Basic
  @Column(name = "comment", nullable = true, length = -1)
  private String comment;

  @Basic
  @Column(name = "status", nullable = true)
  private Integer status = 1;

  @OneToMany(mappedBy = "purchaseCustomerByPurchaseCustomerId", fetch = FetchType.LAZY)
  private List<PurchaseOrderEntity> purchaseOrdersById;

  public int getId() {
    return id;
  }

  public void setId(int id) {
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
    PurchaseCustomerEntity that = (PurchaseCustomerEntity) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(fax, that.fax) && Objects.equals(tel, that.tel) && Objects.equals(contact, that.contact) && Objects.equals(contactPhone, that.contactPhone) && Objects.equals(contactEmail, that.contactEmail) && Objects.equals(taxIdNumber, that.taxIdNumber) && Objects.equals(comment, that.comment) && Objects.equals(status, that.status) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, fax, tel, contact, contactPhone, contactEmail, taxIdNumber, comment, status, createdAt, modifiedAt);
  }

  public List<PurchaseOrderEntity> getPurchaseOrdersById() {
    return purchaseOrdersById;
  }

  public void setPurchaseOrdersById(List<PurchaseOrderEntity> purchaseOrdersById) {
    this.purchaseOrdersById = purchaseOrdersById;
  }
}
