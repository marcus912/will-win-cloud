package org.will.win.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {
  private int id;
  private String name;
  private String address;
  private String fax;
  private String tel;
  private String contact;
  private String contactPhone;
  private String contactEmail;
  private String comment;
  private Byte status;
  private Collection<ItemPriceEntity> itemPricesById;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name", nullable = false, length = 100)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "address", nullable = true, length = 255)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Basic
  @Column(name = "fax", nullable = true, length = 255)
  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  @Basic
  @Column(name = "tel", nullable = true, length = 255)
  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  @Basic
  @Column(name = "contact", nullable = true, length = 255)
  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  @Basic
  @Column(name = "contact_phone", nullable = true, length = 255)
  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  @Basic
  @Column(name = "contact_email", nullable = true, length = 255)
  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  @Basic
  @Column(name = "comment", nullable = true, length = -1)
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Basic
  @Column(name = "status", nullable = true)
  public Byte getStatus() {
    return status;
  }

  public void setStatus(Byte status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomerEntity that = (CustomerEntity) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(fax, that.fax) && Objects.equals(tel, that.tel) && Objects.equals(contact, that.contact) && Objects.equals(contactPhone, that.contactPhone) && Objects.equals(contactEmail, that.contactEmail) && Objects.equals(comment, that.comment) && Objects.equals(status, that.status) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, fax, tel, contact, contactPhone, contactEmail, comment, status, createdAt, modifiedAt);
  }

  @OneToMany(mappedBy = "customerByCustomerId", fetch = FetchType.LAZY)
  public Collection<ItemPriceEntity> getItemPricesById() {
    return itemPricesById;
  }

  public void setItemPricesById(Collection<ItemPriceEntity> itemPricesById) {
    this.itemPricesById = itemPricesById;
  }
}
