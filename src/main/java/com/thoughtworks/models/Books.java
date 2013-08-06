package com.thoughtworks.models;

import java.util.ArrayList;
import java.util.List;



public class Books {

    private List<Book> bookList;

    public List<Book> getBookList() {
        if (bookList == null) {
            bookList = new ArrayList<Book>();
        }
        return bookList;
    }
}
