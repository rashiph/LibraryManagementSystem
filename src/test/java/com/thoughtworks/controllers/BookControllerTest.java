package com.thoughtworks.controllers;

import com.thoughtworks.services.BookService;
import org.junit.Test;
import org.mockito.Mock;

public class BookControllerTest {

    BookController bookController;
    @Mock
    BookService mockedBookService;

//    @Before
//    public void setUp(){
//        initMocks(this);
//        bookController = new BookController(mockedBookService);
//    }

    @Test
    public void shouldCallBookAddService(){
//      bookController.addBook("name");
//      verify(mockedBookService).add("name");
    }
}
