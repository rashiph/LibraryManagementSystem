package com.thoughtworks.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

  @NotEmpty
  @Column(name = "name")
  private String name;

  @NotEmpty
  @Column(name = "author")
  private String author;

  @NotEmpty
  @Column(name = "category")
  private String category;

  @Column(name = "edition")
  private int edition;

  @Column(name = "price")
  private Float price;

  @NotEmpty
  @Column(name = "vendor")
  private String vendor;

  @NotNull
  @Column(name = "createdDate")
  private Date createdDate;

  @NotNull
  @Column(name = "createdBy")
  private String createdBy;

  @Column(name = "updatedDate")
  private Date updatedDate;

  @Column(name = "updatedBy")
  private String updatedBy;

  @NotNull
  @Column(name = "isActive")
  private boolean isActive;

  @NotNull
  @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "book")
  @Column(nullable = false)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<BookDetail> bookDetails;

}



