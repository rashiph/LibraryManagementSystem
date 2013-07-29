package com.thoughtworks.controllers;

import com.thoughtworks.services.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookControllerTest {

    BookController bookController;
    @Mock
    BookService mockedBookService;

    @Before
    public void setUp(){
        initMocks(this);
        bookController = new BookController(mockedBookService);
    }

    @Test
    public void shouldCallBookAddService(){
//      bookController.addBook("name");
//      verify(mockedBookService).add("name");
    }
}
