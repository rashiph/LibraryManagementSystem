package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addBooks(String bookName,String authorName,String category,int edition,float price,Date dateOfPurchase,String vendor,Date createdDate,String createdBy,Date updatedDate,String updatedBy,boolean isActive, int noOfCopies)
    {
//        Book book =
    }

    public Book getOneBook(int searchId)
    {

        return entityManager.find(Book.class,searchId);
    }

    public List getAllBooks()
    {

        return this.entityManager.createQuery("SELECT distinct book FROM Book book").getResultList();

    }

    public Book delete(int id)
    {

        return null;
    }

    public void issueBook(int bookId, Date issueDate, Date returnedDate, int employeeId)
    {

    }

}





