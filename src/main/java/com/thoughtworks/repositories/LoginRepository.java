package com.thoughtworks.repositories;

import com.thoughtworks.models.Admin;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LoginRepository {
  @PersistenceContext
  private EntityManager entityManager;

  public boolean isAdmin(int employeeId) {
    Admin admin = this.entityManager.find(Admin.class, employeeId);
    return admin != null;
  }
}
