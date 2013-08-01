package com.thoughtworks.controllers;

import com.thoughtworks.models.Book;
import com.thoughtworks.services.BookService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Controller
public class BookController {
    @Autowired

    BookService bookService;

    public BookController(BookService bookService){
       this.bookService = bookService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("addBook");

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")

    public ModelAndView addBook(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("category") String category,@RequestParam("edition") String edition,@RequestParam("price") String price,@RequestParam("dateOfPurchase") String dateOfPurchase,@RequestParam("vendor") String vendor) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        Date date = new Date();
         String createdBy = null;
        String updatedBy = null;
        String isActive = null;

        Date dateOfPurchase1 = dateFormat.parse(dateOfPurchase);


        int edition1 = Integer.parseInt(edition);
        float price1 = Float.parseFloat(price);
        ModelAndView modelAndView = new ModelAndView("addBook");
        bookService.add(name,author,category,edition1,price1,dateOfPurchase1,vendor,date,createdBy,date,updatedBy,isActive);
        return modelAndView;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Book> getAllBook()
    {
      List<Book> books = bookService.getAll();
      return books;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET, headers = "Accept=application/json")
    public ModelAndView getBook()    {

        String searchId="4";
        ModelAndView modelAndView = new ModelAndView("getBook");
        bookService.get(searchId);
        return modelAndView;
    }
}
