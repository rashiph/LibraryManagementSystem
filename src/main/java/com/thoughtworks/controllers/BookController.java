package com.thoughtworks.controllers;

import com.thoughtworks.models.Book;
import com.thoughtworks.models.BookDetail;
import com.thoughtworks.models.Books;
import com.thoughtworks.models.IssuedBook;
import com.thoughtworks.repositories.BookDetailRepository;
import com.thoughtworks.repositories.BookRepository;
import com.thoughtworks.repositories.IssuedBookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

@NoArgsConstructor
@Controller
@SessionAttributes(types = Book.class)
public class BookController {
  @Autowired
  private BookRepository repository;

  @Autowired
  private IssuedBookRepository issuedBookRepository;

  @Autowired
  private BookDetailRepository bookDetailRepository;

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  @RequestMapping(value = "/book/index", method = RequestMethod.GET)
  public String index(Map<String, Object> model) {
    Books books = new Books();
    Iterable<Book> all = repository.findAll();
    for (Book book : all) {
      book.setAvailableCopies(book.getBookDetails().size() - issuedBookRepository.findNumberOfBooksById(book.getId()).size());
    }
    books.setBookList((List<Book>) all);
    model.put("books", books);
    return "book/index";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String initCreationOfBook(Map<String, Object> model, HttpServletRequest request) {
    Object attribute = request.getSession().getAttribute("isAdmin");
    if (attribute != null) {
      boolean isAdmin = Boolean.parseBoolean(attribute.toString());
      if (isAdmin) {
        Book book = new Book();
        model.put("book", book);
        return "book/add";
      }
    }
    return "book/index";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String processCreationOfBook(@ModelAttribute("book") @Valid Book book, BindingResult result, SessionStatus status, HttpServletRequest request) {
    Integer noOfCopies = Integer.valueOf(request.getParameter("noOfCopies"));
    Date dateOfPurchase = new Date((request.getParameter("dateOfPurchase")));

    if (result.hasErrors()) {
      return "book/add";
    } else {
      if (noOfCopies > 0) {
        BookDetail bookDetail;
        List<BookDetail> bookDetails = new ArrayList<BookDetail>();
        for (int i = 0; i < noOfCopies; i++) {
          bookDetail = new BookDetail();

          bookDetail.setDateOfPurchase(dateOfPurchase);
          bookDetail.setActive(true);
          bookDetail.setBook(book);
          bookDetails.add(bookDetail);
        }
        book.setBookDetails(bookDetails);
      }
      this.repository.save(book);
      status.setComplete();
      return "book/index";
    }
  }

  @RequestMapping(value = "/{bookId}/edit", method = RequestMethod.GET)
  public String initUpdateOfBook(@Valid @PathVariable("bookId") Long bookId, Model model) {
    Book book = this.repository.findOne(bookId);
    model.addAttribute(book);
    return "book/add";
  }

  @RequestMapping(value = "/{bookId}/edit", method = RequestMethod.PUT)
  public String processUpdateOfBook(@Valid Book book, BindingResult result, SessionStatus status, HttpServletRequest request) {
    Integer noOfCopies = Integer.valueOf(request.getParameter("noOfCopies"));
    Date dateOfPurchase = new Date((request.getParameter("dateOfPurchase")));

    if (result.hasErrors()) {
      return "book/add";
    } else {
      if (noOfCopies > 0) {
        if (book.getBookDetails().size() > 0) {
          bookDetailRepository.delete(book.getBookDetails());
        }
        BookDetail bookDetail;
        List<BookDetail> bookDetails = new ArrayList<BookDetail>();
        for (int i = 0; i < noOfCopies; i++) {
          bookDetail = new BookDetail();

          bookDetail.setDateOfPurchase(dateOfPurchase);
          bookDetail.setActive(true);
          bookDetail.setBook(book);
          bookDetails.add(bookDetail);
        }
        book.setBookDetails(bookDetails);
      }
      this.repository.save(book);
      status.setComplete();
      return "book/index";
    }
  }

  @RequestMapping(value = "/books/{bookId}/deleteBook", method = RequestMethod.GET, headers = "Accept=application/json")
  public String deleteBook(@PathVariable("bookId") Long bookId, SessionStatus status, HttpServletResponse response, HttpServletRequest request, Map<String, Object> model) {
    Book book = repository.findOne(bookId);
    book.setActive(false);
    this.repository.save(book);
    status.setComplete();
    response.setStatus(200);
//
//      Iterable<BookDetail> bookDetail = bookDetailRepository.findAll();
//      List<BookDetail> bookDetails = new ArrayList<BookDetail>();
//      bookDetails.addAll((Collection<? extends BookDetail>)bookDetail);
//      model.put("bookDetails", bookDetails);
//      return "book/index";
    return "redirect:/";
  }

  @RequestMapping(value = "/books/{bookId}/issue", method = RequestMethod.GET)
  public String issueBook(@Valid @PathVariable("bookId") int bookId, SessionStatus status, HttpServletRequest request, ModelMap model) {
    Object attribute = request.getSession().getAttribute("employeeId");
    if (attribute != null) {
      IssuedBook book = new IssuedBook();
      book.setBookId(bookId);
      book.setEmployeeId((Integer) attribute);
      book.setActive(true);
      issuedBookRepository.save(book);
      model.addAttribute("message", "yahoo");
      return "book/index";
    }
    return "book/index";
  }
}
