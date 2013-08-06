package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Mock
    Session mockedSession;

    @Mock
    SessionFactory mockedSessionFactory;

    @Mock
    org.hibernate.Transaction mockedTransaction;

    @Before
    public void setUp() {
        initMocks(this);
//      bookRepository = new BookRepository(mockedSessionFactory, mockedSession);
        when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
    }

    @Test
    public void shouldAddBook() {
//        bookRepository.add("bookName");
//        verify(mockedSession).save(anyString(),anyObject());
//        verify(mockedTransaction).commit();
    }


    @Test
    public void shouldGetAllBooks() {
        Collection<Book> allBooks = bookRepository.getAllBooks();
    }
}
