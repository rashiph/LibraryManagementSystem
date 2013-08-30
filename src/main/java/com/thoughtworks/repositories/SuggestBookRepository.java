package com.thoughtworks.repositories;

import com.thoughtworks.models.SuggestBook;
import org.springframework.data.repository.CrudRepository;

public interface SuggestBookRepository extends CrudRepository<SuggestBook, Long> {
}
