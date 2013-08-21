package com.thoughtworks.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

  @NotNull
  @Column(name = "employeeId", unique = true)
  private int employeeId;

  @NotEmpty
  @Column(name = "userName")
  private String userName;

  @NotEmpty
  @Column(name = "password")
  private String password;

  @Column(name = "isActive")
  private boolean isActive;

  @Column(name = "isAdmin")
  private boolean isAdmin;

}