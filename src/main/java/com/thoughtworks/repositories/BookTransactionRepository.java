package com.thoughtworks.repositories;

import com.thoughtworks.models.BookTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookTransactionRepository extends CrudRepository<BookTransaction, Long> {

  @Query("From BookTransaction book where book.bookId = :bookId and book.returnedDate = NULL")
  public List<BookTransaction> findBooksById(@Param("bookId") Long bookId);

  @Query("Select book from BookTransaction book where book.employeeId = :employeeId and book.returnedDate = NULL")
  public List<BookTransaction> findBooksByEmployeeId(@Param("employeeId") Long employeeId);

  @Query("Select book from BookTransaction book where book.employeeId = :employeeId and book.bookId = :bookId and book.returnedDate = NULL")
  public BookTransaction findBookByEmployeeIdAndBookId(@Param("employeeId") Long employeeId,
                                                       @Param("bookId") Long bookId);
}
