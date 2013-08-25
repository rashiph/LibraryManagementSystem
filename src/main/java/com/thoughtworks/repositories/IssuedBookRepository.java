package com.thoughtworks.repositories;

import com.thoughtworks.models.IssuedBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssuedBookRepository extends CrudRepository<IssuedBook, Long> {

  @Query("From IssuedBook book where book.bookId = :bookId and book.returnedDate = NULL")
  public List<IssuedBook> findBooksById(@Param("bookId") Long bookId);

  @Query("Select book from IssuedBook book where book.employeeId = :employeeId and book.returnedDate = NULL")
  public List<IssuedBook> findBooksByEmployeeId(@Param("employeeId") Long employeeId);


}
