package com.thoughtworks.repositories;

import com.thoughtworks.models.IssuedBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssuedBookRepository extends CrudRepository<IssuedBook, Long> {

  @Query("Select book from IssuedBook book where book.bookId = :bookId and book.returnedDate = NULL")
  public List<IssuedBook> findNumberOfBooksById(@Param("bookId") Long bookId);
}
