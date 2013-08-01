package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import com.thoughtworks.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
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
        session = sessionFactory.openSession();

    }
    public void add(String name,String author,String category,int edition,Float price,Date dateOfPurchase,String vendor,Date createdDate,String createdBy,Date updatedDate,String updatedBy,String isActive) {

        Book book = new Book(name,author,category,edition,price,dateOfPurchase,vendor,createdDate,createdBy,updatedDate,updatedBy,isActive);
        session.save("books", book);

        Transaction tx = session.beginTransaction();

        tx.commit();

    }

    public Book get(String searchId)
    {

       Book obj = null;
        String query = "from Book as b where b.id = :sId";
        List<Book> listofbooks = session.createQuery(query).setString("sId", searchId).list();

        Iterator iterator = listofbooks.iterator();

        while (iterator.hasNext()) {
            obj = (Book) iterator.next();

            System.out.print("###################"+obj.getName() + "\t" + obj.getAuthor() + "\t" + obj.getCategory() +obj.getEdition() + "\t" + obj.getPrice() + "\t" + obj.getDateOfPurchase() +"\t"+ obj.getVendor()+"\t"+obj.getCreatedDate()+"\t"+obj.getCreatedBy()+"\t"+obj.getUpdatedDate()+"\t"+obj.getIsActive());
    }
        return  obj;
    }

    public List<Book> getAllBooks()
    {
        List <Book> listOfBooks = new ArrayList<Book>();
        Query query =  session.createQuery("from Book b");
       List list = query.list();
       Iterator<Book> itr = list.iterator();
      while(itr.hasNext())
      {
          listOfBooks.add(itr.next());
      }
     return  listOfBooks;
    }
}


