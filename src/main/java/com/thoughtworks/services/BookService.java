package com.thoughtworks.services;

import com.thoughtworks.models.Book;
import com.thoughtworks.repositories.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@NoArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void add(String name,String author,String category,int edition,Float price,Date dateOfPurchase,String vendor, Date createdDate,String createdBy, Date updatedDate,String updatedBy,boolean isActive) {
        new BookRepository().add(name,author,category,edition,price,dateOfPurchase,vendor,createdDate,createdBy,updatedDate,updatedBy,isActive);
    }



    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }



    public List<Book> getAll()
    {
        return bookRepository.getAllBooks();
    }



    public Book get(int searchId){
        return bookRepository.getOneBook(searchId);

    }



    public Book deleteBook(int id)
    {
       return bookRepository.delete(id);

    }


    public void issue(int bookId,Date issueDate,Date returnedDate,int employeeId)
    {
        bookRepository.issueBook(bookId,issueDate,returnedDate,employeeId);
    }

}
