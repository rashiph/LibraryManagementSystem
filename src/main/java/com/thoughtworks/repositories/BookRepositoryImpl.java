package com.thoughtworks.repositories;

//import com.thoughtworks.models.Admin;
import com.thoughtworks.models.Admin;
import com.thoughtworks.models.Book;
import com.thoughtworks.models.IssueBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookRepositoryImpl {

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

  public Book delete(int id) {
    entityManager.getCriteriaBuilder();

    Book book = (Book) this.entityManager.find(Book.class, id);

//        book.setIsActive(false);
    return book;
  }


  public void issueBook(int bookId, Date issueDate, Date returnedDate, int employeeId) {
    IssueBook issueBook = new IssueBook(bookId, issueDate, returnedDate, employeeId);
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





