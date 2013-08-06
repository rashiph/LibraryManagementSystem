package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import com.thoughtworks.models.IssueBook;
import com.thoughtworks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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


    }
    public void add(String name,String author,String category,int edition,Float price,Date dateOfPurchase,String vendor,Date createdDate,String createdBy,Date updatedDate,String updatedBy,boolean isActive) {
        Session session =   sessionFactory.openSession();
        session.beginTransaction();

        Book book = new Book(name,author,category,edition,price,dateOfPurchase,vendor,createdDate,createdBy,updatedDate,updatedBy,isActive);
        session.save("books", book);

        Transaction tx = session.beginTransaction();

        tx.commit();

    }

    public Book getOneBook(int searchId)
    {
        Session session =   sessionFactory.openSession();
        session.beginTransaction();
        Book book = (Book) session.get(Book.class,searchId);
        session.getTransaction().commit();
        return book;
    }

    public List<Book> getAllBooks()
    {
        Session session =   sessionFactory.openSession();
        session.beginTransaction();
        ArrayList <Book> listOfBooks = new ArrayList<Book>();
        Query query =  session.createQuery("from Book b where isActive = true");
        List list = query.list();
        Iterator<Book> itr = list.iterator();
        while(itr.hasNext())
        {
            listOfBooks.add(itr.next());
        }
        session.getTransaction().commit();
        return  listOfBooks;
    }

    public Book delete(int id){
        Session session =   sessionFactory.openSession();
        session.beginTransaction();

        Query query =  session.createQuery("UPDATE Book set isActive=false where id="+id);
        query.executeUpdate();
        session.getTransaction().commit();
        Book book = (Book) session.get(Book.class,id);
        return book;
    }

    public void issueBook(int bookId,Date issueDate,Date returnedDate,int employeeId)
    {
        Session session =   sessionFactory.openSession();
        session.beginTransaction();

        IssueBook objIssueBook = new IssueBook(bookId,issueDate,returnedDate,employeeId);
        session.save("issued_book", objIssueBook);

        Transaction tx = session.beginTransaction();
        tx.commit();

    }
}


