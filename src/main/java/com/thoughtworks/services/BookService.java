//package com.thoughtworks.services;
//
//import com.thoughtworks.models.Book;
//import com.thoughtworks.models.IssueBook;
//import com.thoughtworks.repositories.BookRepository;
//import com.thoughtworks.repositories.BookRepositoryImpl;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//@NoArgsConstructor
//public class BookService {
//  @Autowired
//  BookRepositoryImpl bookRepositoryImpl;
//
//  public BookService(BookRepositoryImpl bookRepositoryImpl) {
//    this.bookRepositoryImpl = bookRepositoryImpl;
//  }
//
//  public List getAll(){
//    return bookRepository.getAllBooks();
//  }
//
//  public Book get(int searchId){
//    return bookRepository.getOneBook(searchId);
//  }
//
//  public void deleteBook(int id){
//    bookRepository.delete(id);
//  }
//
//  public void issue(IssueBook issueBook)
//  {
//    bookRepository.issueBook(issueBook);
//  }
//
//  public void save(Book book){
//    bookRepository.save(book);
//  public List getAll() {
//    return bookRepositoryImpl.getAllBooks();
//  }
//
//  public Book get(int searchId) {
//    return bookRepositoryImpl.getOneBook(searchId);
//  }
//
//  public Book deleteBook(int id) {
//    return bookRepositoryImpl.delete(id);
//  }
//
//  public void issue(int bookId, Date issueDate, Date returnedDate, int employeeId) {
//    bookRepositoryImpl.issueBook(bookId, issueDate, returnedDate, employeeId);
//  }
//
//
//  public void save(Book book) {
//    bookRepositoryImpl.save(book);
//  }
//}
//
//
//
//
