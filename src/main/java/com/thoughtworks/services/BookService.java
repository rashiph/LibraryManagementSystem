package com.thoughtworks.services;

import com.thoughtworks.repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void add(String name) {
        bookRepository.add(name);
        //To change body of created methods use File | Settings | File Templates.
    }
}
