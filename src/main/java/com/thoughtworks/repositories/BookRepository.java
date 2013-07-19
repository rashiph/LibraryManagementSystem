package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import com.thoughtworks.utils.HibernateUtil;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BookRepository {
    private SessionFactory sessionFactory;
    private Session session;

    public BookRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();

    }

    public void add(String name) {
        Book book = new Book();
        book.setName(name);
        session.save("books", book);
        Transaction tx = session.beginTransaction();
        tx.commit();

    }
}
