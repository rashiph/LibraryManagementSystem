package com.thoughtworks.repositories;

import com.thoughtworks.models.IssuedBook;
import org.springframework.data.repository.CrudRepository;

public interface IssuedBookRepository extends CrudRepository<IssuedBook, Long> {
}
