package com.thoughtworks.repositories;

import com.thoughtworks.models.BookDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookDetailRepository extends CrudRepository<BookDetail, Long> {
  @Modifying
  @Transactional
  @Query("delete from BookDetail bd where bd.id = :id")
  public void deleteById(@Param("id")Long id);

}
