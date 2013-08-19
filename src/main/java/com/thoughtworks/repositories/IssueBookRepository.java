package com.thoughtworks.repositories;

import com.thoughtworks.models.IssueBook;
import org.springframework.data.repository.CrudRepository;

public interface IssueBookRepository extends CrudRepository<IssueBook, Long> {
}
