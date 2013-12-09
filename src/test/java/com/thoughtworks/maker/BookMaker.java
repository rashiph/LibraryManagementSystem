package com.thoughtworks.maker;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;
import com.thoughtworks.models.Book;

import java.util.Date;

public class BookMaker {

  public static final Property<Book, Long> id = new Property<Book, Long>();
  public static final Property<Book, String> name = new Property<Book, String>();
  public static final Property<Book, String> author = new Property<Book, String>();
  public static final Property<Book, String> category = new Property<Book, String>();
  public static final Property<Book, Integer> edition = new Property<Book, Integer>();
  public static final Property<Book, Float> price = new Property<Book, Float>();
  public static final Property<Book, String> vendor = new Property<Book, String>();
  public static final Property<Book, Date> createdDate = new Property<Book, Date>();
  public static final Property<Book, String> createdBy = new Property<Book, String>();
  public static final Property<Book, Date> updatedDate = new Property<Book, Date>();
  public static final Property<Book, String> updatedBy = new Property<Book, String>();
  public static final Property<Book, Boolean> isActive = new Property<Book, Boolean>();

  public static final Instantiator<Book> Book = new Instantiator<Book>() {
    public Book instantiate(PropertyLookup<Book> lookup) {
      Book book = new Book();
      book.setId(lookup.valueOf(id, (Long) null));
      book.setName(lookup.valueOf(name, "new-Book"));
      book.setAuthor(lookup.valueOf(author, "new-Author"));
      book.setCategory(lookup.valueOf(category, "new-Category"));
      book.setEdition(lookup.valueOf(edition, 1));
      book.setPrice(lookup.valueOf(price, 100.50f));
      book.setVendor(lookup.valueOf(vendor, "new-Vendor"));
      book.setCreatedDate(lookup.valueOf(createdDate, new Date()));
      book.setCreatedBy(lookup.valueOf(createdBy, "new-Creator"));
      book.setUpdatedDate(lookup.valueOf(updatedDate, new Date()));
      book.setUpdatedBy(lookup.valueOf(updatedBy, "new-UpdatedBy"));
      book.setIsActive(lookup.valueOf(isActive, true));
      return book;
    }
  };
}
