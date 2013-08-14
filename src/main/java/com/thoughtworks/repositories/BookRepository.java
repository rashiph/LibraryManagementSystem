package com.thoughtworks.repositories;

import com.thoughtworks.models.Admin;
import com.thoughtworks.models.Book;
import com.thoughtworks.models.IssueBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public Book getOneBook(int searchId) {

    return this.entityManager.find(Book.class, searchId);
  }

  public List getAllBooks() {

    List<Object[]> results = this.entityManager.createQuery("SELECT b.name AS name, b.author AS author,b.category AS category, b.edition AS edition, COUNT(b) AS total " +
        "FROM Book AS b GROUP BY b.name, b.author,b.edition ")
        .getResultList();
    List<Book> bookList = new ArrayList<Book>();
    for (Object[] result : results) {

      Book book = new Book((String) result[0], (String) result[1], (String) result[2], ((Number) result[3]).intValue(), ((Number) result[4]).intValue());
      bookList.add(book);
    }

    return bookList;
  }

  public void delete(int id) {

    entityManager.createQuery("UPDATE Book set isActive = false where id=" + id).executeUpdate();
  }


  public void issueBook(IssueBook issueBook) {

    this.entityManager.persist(issueBook);
  }

  public void save(Book book) {
    if (book.getId() == null) {
      this.entityManager.persist(book);
    } else {
      this.entityManager.merge(book);
    }
  }


}





