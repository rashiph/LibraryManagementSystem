package com.thoughtworks.controllers;

import com.thoughtworks.models.Book;
import com.thoughtworks.models.BookTransaction;
import com.thoughtworks.models.Books;
import com.thoughtworks.repositories.BookRepository;
import com.thoughtworks.repositories.BookTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class BookTransactionController {
  @Autowired
  private BookRepository repository;

  @Autowired
  private BookTransactionRepository bookTransactionRepository;

  @RequestMapping(value = "/book/return", method = RequestMethod.GET)
  public String issuedBooks(Map<String, Object> model, HttpServletRequest request) {
    Object attribute = request.getSession().getAttribute("isLogin");
    if (attribute != null) {
      attribute = request.getSession().getAttribute("employeeId");
      List<BookTransaction> bookTransactions = bookTransactionRepository.findBooksByEmployeeId((Long) attribute);
      Books books = new Books();
      List<Book> bookList = new ArrayList<Book>();
      for (BookTransaction bookTransaction : bookTransactions) {
        Book book = repository.findOne(bookTransaction.getBookId());
        book.setIssueDate(bookTransaction.getIssueDate());
        bookList.add(book);
      }
      books.setBookList(bookList);
      model.put("books", books);
      return "book/return";
    }
    return "redirect:/";
  }

  @RequestMapping(value = "/{bookId}/issue", method = RequestMethod.GET)
  public String issueBook(@Valid @PathVariable("bookId") Long bookId, HttpServletRequest request, ModelMap model) {
    Object attribute = request.getSession().getAttribute("employeeId");
    if (attribute != null) {
      BookTransaction book = new BookTransaction();
      book.setBookId(bookId);
      book.setEmployeeId((Long) attribute);
      book.setIssueDate(new Date());
      book.setActive(true);
      bookTransactionRepository.save(book);
//      model.addAttribute("message", "yahoo");
      return "redirect:/book/return";
    }
    return "redirect:/";
  }

  @RequestMapping(value = "/{bookId}/return", method = RequestMethod.GET)
  public String returnBook(@Valid @PathVariable("bookId") Long bookId, HttpServletRequest request, ModelMap model) {
    Object attribute = request.getSession().getAttribute("employeeId");
    if (attribute != null) {
      BookTransaction bookTransaction = bookTransactionRepository.findBookByEmployeeIdAndBookId((Long) attribute, bookId);
      bookTransaction.setReturnedDate(new Date());
      bookTransactionRepository.save(bookTransaction);
      return "redirect:/book/return";
    }
    return "redirect:/";
  }
}
