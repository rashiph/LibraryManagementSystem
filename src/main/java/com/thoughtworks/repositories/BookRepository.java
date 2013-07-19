package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import com.thoughtworks.utils.HibernateUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.management.Query;

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
    }
}
