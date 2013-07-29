package com.thoughtworks.controllers;

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
        System.out.println("######################################check1");
        ModelAndView modelAndView = new ModelAndView("addBook");
        System.out.println("check2");

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")

    public ModelAndView addBook(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("category") String category,@RequestParam("edition") String edition,@RequestParam("price") String price,@RequestParam("dateOfPurchase") String dateOfPurchase,@RequestParam("vendor") String vendor) throws ParseException {
        System.out.println("check3");
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date();
//        DateTimeFormatter formatter = ISODateTimeFormat.date();


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
}
