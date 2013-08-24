package com.thoughtworks.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "issued_books")
public class IssuedBook extends BaseEntity {

  @NotNull
  @Column(name = "bookId")
  private long bookId;

  @NotNull
  @Column(name = "issueDate")
  private Date issueDate;

  @Column(name = "returnedDate")
  private Date returnedDate;

  @NotNull
  @Column(name = "employeeId")
  private int employeeId;

  @NotNull
  @Column(name = "isActive")
  private boolean isActive;
}
