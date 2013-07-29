package com.thoughtworks.services;


import com.thoughtworks.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookServiceTest {
    BookService bookService;

    @Mock
    BookRepository mockedBookRepository;

    @Before
    public void setUp(){
        initMocks(this);
        bookService = new BookService(mockedBookRepository);
    }

    @Test
    public void shouldCallAdd(){
//        bookService.add("name");
//        verify(mockedBookRepository).add("name");
    }
}
