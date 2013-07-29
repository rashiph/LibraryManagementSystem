package com.thoughtworks.services;

import com.thoughtworks.repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void add(String name,String author,String category,int edition,Float price,Date dateOfPurchase,String vendor, Date createdDate,String createdBy, Date updatedDate,String updatedBy,String isActive) {
        bookRepository.add(name,author,category,edition,price,dateOfPurchase,vendor,createdDate,createdBy,updatedDate,updatedBy,isActive);
        //To change body of created methods use File | Settings | File Templates.
    }
}
