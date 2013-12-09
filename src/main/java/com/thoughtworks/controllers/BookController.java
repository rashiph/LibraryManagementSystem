package com.thoughtworks.controllers;

import com.thoughtworks.models.*;
import com.thoughtworks.repositories.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Controller
@SessionAttributes(types = Book.class)
public class BookController {
  @Autowired
  private BookRepository repository;

  @Autowired
  private BookTransactionRepository bookTransactionRepository;

  @Autowired
  private BookDetailRepository bookDetailRepository;

  @Qualifier("userRepository")
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private SuggestBookRepository suggestBookRepository;


  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  @RequestMapping(value = "/book/index", method = RequestMethod.GET)
  public String index(Map<String, Object> model, HttpServletRequest request) {
    Object attribute = request.getSession().getAttribute("isLogin");
    if (attribute != null) {
      Books books = new Books();
      Iterable<Book> all = repository.findAll();
      for (Book book : all) {
        book.setAvailableCopies(book.getBookDetails().size() - bookTransactionRepository.findBooksById(book.getId()).size());
      }
      books.setBookList((List<Book>) all);
      model.put("books", books);
      return "book/index";
    }
    return "redirect:/";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String initCreationOfBook(Map<String, Object> model, HttpServletRequest request) {
    Object attribute = request.getSession().getAttribute("isLogin");
    if (attribute != null) {
      attribute = request.getSession().getAttribute("isAdmin");
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
    return "redirect:/";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String processCreationOfBook(@ModelAttribute("book") @Valid Book book, BindingResult result, SessionStatus status, HttpServletRequest request, RedirectAttributes attributes) {
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
          bookDetail.setIsActive(true);
          bookDetail.setBook(book);
          bookDetails.add(bookDetail);
        }
        book.setBookDetails(bookDetails);
      }
      this.repository.save(book);
      status.setComplete();
      attributes.addFlashAttribute("successMessage", "Book added successfully!");
      return "redirect:book/index";
    }
  }

  @RequestMapping(value = "/{bookId}/edit", method = RequestMethod.GET)
  public String initUpdateOfBook(@Valid @PathVariable("bookId") Long bookId, Model model, HttpServletRequest request) {
    Object attribute = request.getSession().getAttribute("isLogin");
    if (attribute != null) {
      attribute = request.getSession().getAttribute("isAdmin");
      if (attribute != null) {
        boolean isAdmin = Boolean.parseBoolean(attribute.toString());
        if (isAdmin) {
          Book book = this.repository.findOne(bookId);
          model.addAttribute(book);
          return "book/add";
        }
      }
      return "book/index";
    }
    return "redirect:/";
  }

  @RequestMapping(value = "/{bookId}/edit", method = RequestMethod.PUT)
  public String processUpdateOfBook(@Valid Book book, BindingResult result, SessionStatus status, HttpServletRequest request) {
    Integer noOfCopies = Integer.valueOf(request.getParameter("noOfCopies"));
    Date dateOfPurchase = new Date((request.getParameter("dateOfPurchase")));

    if (result.hasErrors()) {
      return "book/add";
    } else {
      if (noOfCopies > 0) {
        List<BookDetail> bookDetails1 = book.getBookDetails();
        if (bookDetails1.size() > 0) {
          for (int i = 0; i < bookDetails1.size(); i++)
            bookDetailRepository.deleteById(bookDetails1.get(i).getId());
        }
        BookDetail bookDetail;
        List<BookDetail> bookDetails = new ArrayList<BookDetail>();
        for (int i = 0; i < noOfCopies; i++) {
          bookDetail = new BookDetail();

          bookDetail.setDateOfPurchase(dateOfPurchase);
          bookDetail.setIsActive(true);
          bookDetail.setBook(book);
          bookDetails.add(bookDetail);
        }
        book.setBookDetails(bookDetails);
      }
      this.repository.save(book);
      status.setComplete();
      return "redirect:/book/index";
    }
  }

  @RequestMapping(value = "/book/borrower", method = RequestMethod.GET)
  public
  @ResponseBody
  String borrower(Long bookId) {
    List<BookTransaction> bookTransactions = bookTransactionRepository.findBooksById(bookId);
    List<String> userNames = new ArrayList<String>();
    for (BookTransaction book : bookTransactions) {
      userNames.add(userRepository.findOne(book.getEmployeeId()).getFullName());
    }
    return userNames.toString();
  }

  @RequestMapping(value = "/suggest", method = RequestMethod.GET)
  public String suggestBook(Map<String, Object> model) {

    SuggestBook suggestBook = new SuggestBook();
    model.put("suggestBook", suggestBook);
    return "user/suggest";
  }

  @RequestMapping(value = "/suggest", method = RequestMethod.POST)
  public String suggestBook(@ModelAttribute("suggestBook") @Valid SuggestBook suggestBook, HttpServletRequest request, SessionStatus status, RedirectAttributes attributes) {

    Long employeeId = (Long) request.getSession().getAttribute("employeeId");
    this.suggestBookRepository.save(suggestBook);
    status.setComplete();
    attributes.addFlashAttribute("successMessage", "Book suggest bb successfully!");
    return "redirect:/book/index";
  }
}