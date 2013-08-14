package com.thoughtworks.controllers;

import com.thoughtworks.models.Book;
import com.thoughtworks.models.Books;
import com.thoughtworks.models.IssueBook;
import com.thoughtworks.services.BookService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
@Controller
@SessionAttributes(types = Book.class)
public class BookController {
  @Autowired
  BookService bookService;


  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Map<String, Object> model) {

    Books books = new Books();
    books.getBookList().addAll(bookService.getAll());
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
    return "redirect:/";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String processCreationOfBook(@ModelAttribute("book") @Valid Book book, BindingResult result, SessionStatus status) {
    if (result.hasErrors()) {
      return "book/add";
    } else {
      this.bookService.save(book);
      status.setComplete();
      return "redirect:/";
    }
  }

  @RequestMapping(value = "/books/{bookId}/edit", method = RequestMethod.GET)
  public String initUpdateOfBook(@PathVariable("bookId") int bookId, Model model) {
    Book book = this.bookService.get(bookId);
    model.addAttribute(book);
    return "book/add";
  }

  @RequestMapping(value = "/books/{bookId}/edit", method = RequestMethod.PUT)
  public String processUpdateOfBook(@Valid Book book, BindingResult result, SessionStatus status) {
    if (result.hasErrors()) {
      return "book/add";
    } else {
      this.bookService.save(book);
      status.setComplete();
      return "redirect:/";
    }
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
  public ModelAndView addBook(@RequestParam("bookName") String bookName, @RequestParam("authorName") String authorName, @RequestParam("category") String category, @RequestParam("edition") String edition, @RequestParam("price") String price, @RequestParam("dateOfPurchase") String dateOfPurchase, @RequestParam("vendor") String vendor) throws ParseException {

    DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
    Date date = new Date();
    String createdBy = null;
    String updatedBy = null;
    int noOfCopies = 1;
    boolean isActive = true;

    Date dateOfPurchase1 = dateFormat.parse(dateOfPurchase);


    int edition1 = Integer.parseInt(edition);
    float price1 = Float.parseFloat(price);
    ModelAndView modelAndView = new ModelAndView("addBook");
//    bookService.add(bookName, authorName, category, edition1, price1, dateOfPurchase1, vendor, date, createdBy, date, updatedBy, isActive, noOfCopies);

    return modelAndView;
  }


  @RequestMapping(value = "/deleteBook", method = RequestMethod.GET, headers = "Accept=application/json")
  public String deleteBook() {
    int id = 1;
    bookService.deleteBook(id);
      return "redirect:/";
  }

    @RequestMapping(value = "/books/{bookId}/issue", method = RequestMethod.GET)
    public String login_request(Map<String, Object> model) {
        IssueBook issueBook = new IssueBook();
        model.put("book", issueBook);
        return "redirect:/";
    }
    @RequestMapping(value = "/books/{bookId}/issue", method = RequestMethod.POST)
    public String issue(@RequestParam("bookId") int bookId) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    Date date = new Date();
    int employeeId = 0;
    Date returnedDate = null;
    IssueBook issueBook = new IssueBook(bookId, date, returnedDate, employeeId);
    bookService.issue(issueBook);
    return "redirect:/";

    }

}
