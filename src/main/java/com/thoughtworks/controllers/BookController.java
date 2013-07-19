package com.thoughtworks.controllers;

import com.thoughtworks.services.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@NoArgsConstructor
@AllArgsConstructor
@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("addBook");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    public ModelAndView addBook(@RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView("addBook");
        bookService.add(name);
        return modelAndView;
    }
}
