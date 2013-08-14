package com.thoughtworks.services;

import com.thoughtworks.models.Book;
import com.thoughtworks.models.IssueBook;
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

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List getAll(){
    return bookRepository.getAllBooks();
  }

  public Book get(int searchId){
    return bookRepository.getOneBook(searchId);
  }

  public void deleteBook(int id){
    bookRepository.delete(id);
  }

  public void issue(IssueBook issueBook)
  {
    bookRepository.issueBook(issueBook);
  }

  public void save(Book book){
    bookRepository.save(book);
  }
}




