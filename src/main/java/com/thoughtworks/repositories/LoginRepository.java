package com.thoughtworks.repositories;

import com.thoughtworks.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Admin, Long> {
}
