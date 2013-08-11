package com.thoughtworks.services;

import com.thoughtworks.repositories.LoginRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class LoginService {

  @Autowired
  LoginRepository repository;

  public boolean login(int EmployeeId) {
    return repository.isAdmin(EmployeeId);
  }


}
