package com.thoughtworks.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "book_details")
public class BookDetail extends BaseEntity {

  @ManyToOne( fetch = FetchType.EAGER )
  @JoinColumn(name = "book_id", nullable = false )
  private Book book;

  @NotNull
  @Column(name = "dateOfPurchase")
  private Date dateOfPurchase;

  @NotNull
  @Column(name = "isActive")
  private boolean isActive;

}
