package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import com.thoughtworks.utils.HibernateUtil;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class BookRepository {
    private SessionFactory sessionFactory;
    private Session session;

    public BookRepository(SessionFactory sessionFactory, Session session) {
        this.sessionFactory = sessionFactory;
        this.session = session;

    }

    public BookRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();

    }

    public void add(String name,String author,String category,int edition,Float price,Date dateOfPurchase,String vendor,Date createdDate,String createdBy,Date updatedDate,String updatedBy,String isActive) {

        Book book = new Book(name,author,category,edition,price,dateOfPurchase,vendor,createdDate,createdBy,updatedDate,updatedBy,isActive);
        session.save("books", book);
        Transaction tx = session.beginTransaction();
        tx.commit();

    }
}
