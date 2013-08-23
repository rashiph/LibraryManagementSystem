package com.thoughtworks.repositories;

import com.thoughtworks.models.BookDetail;
import org.springframework.data.repository.CrudRepository;

public interface BookDetailRepository extends CrudRepository<BookDetail, Long> {
}
