package com.thoughtworks.services;


import com.thoughtworks.repositories.BookRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookServiceTest {
    BookService bookService;

    @Mock
    BookRepositoryImpl mockedBookRepositoryImpl;

    @Before
    public void setUp(){
        initMocks(this);
        bookService = new BookService(mockedBookRepositoryImpl);
    }

    @Test
    public void shouldCallAdd(){
//        bookService.add("name");
//        verify(mockedBookRepository).add("name");
    }
}
