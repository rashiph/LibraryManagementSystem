package com.thoughtworks.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

  @NotEmpty
  @Column(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  @NotEmpty
  @Column(name = "author")
  private String author;

  public String getAuthor() {
    return author;
  }

  @NotEmpty
  @Column(name = "category")
  private String category;

  public String getCategory() {
    return category;
  }

  //
  @Column(name = "edition")
  private int edition;

  public int getEdition() {
    return edition;
  }

  //
  @Column(name = "price")
  private Float price;

  public Float getPrice() {
    return price;
  }

  //
  @Column(name = "dateOfPurchase")
  private Date dateOfPurchase;

  public Date getDateOfPurchase() {
    return dateOfPurchase;
  }

  @NotEmpty
  @Column(name = "vendor")
  private String vendor;

  public String getVendor() {
    return vendor;
  }

  //
  @Column(name = "createdDate")
  private Date createdDate;

  public Date getCreatedDate() {
    return createdDate;
  }

  //
  @Column(name = "createdBy")
  private String createdBy;

  public String getCreatedBy() {
    return createdBy;
  }

  //
  @Column(name = "updatedDate")
  private Date updatedDate;

  public Date getUpdatedDate() {
    return updatedDate;
  }

  //
  @Column(name = "updatedBy")
  private String updatedBy;

  public String getUpdatedBy() {
    return updatedBy;
  }

  //
  @Column(name = "isActive")
  private boolean isActive;

  public boolean getIsActive() {
    return isActive;
  }

  //
  @Column(name = "noOfCopies")
  private int noOfCopies;

  public int getNoOfCopies() {
    return noOfCopies;
  }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies= noOfCopies;
    }

    public Book() {

    }

    public Book(String name, String author, String category, int edition, Float price, Date dateOfPurchase, String vendor, Date createdDate, String createdBy, Date updatedDate, String updatedBy, boolean isActive, int noOfCopies) {

        this.name = name;
        this.author = author;
        this.category = category;
        this.edition = edition;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
        this.vendor = vendor;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.isActive = isActive;
        this.noOfCopies = noOfCopies;
    }

    public Book(String name, String author, String category, int edition,int noOfCopies) {

        this.name = name;
        this.author = author;
        this.category = category;
        this.edition = edition;
        this.noOfCopies = noOfCopies;
    }
}



