package com.thoughtworks.repositories;

//import com.thoughtworks.models.Admin;
import com.thoughtworks.models.Admin;
import com.thoughtworks.models.Book;
import com.thoughtworks.models.IssueBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookRepository {

  @PersistenceContext
  private EntityManager entityManager;

    public Book getOneBook(int searchId)
     {

        return this.entityManager.find(Book.class,searchId);
     }

     public List getAllBooks()
     {

        return this.entityManager.createQuery("SELECT distinct book FROM Book book").getResultList();
      }

     public Book delete(int id)
     {
         entityManager.getCriteriaBuilder();

        Book book =(Book)this.entityManager.find(Book.class,id);

//        book.setIsActive(false);
        return book;
     }


  public void issueBook(int bookId, Date issueDate, Date returnedDate, int employeeId)
  {
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

    public boolean login(int employeeId)  {
        Admin admin = this.entityManager.find(Admin.class, employeeId);
        if (admin==null)
        {
            return false;
        }
        else
        {
            return true;
        }
   }
}





