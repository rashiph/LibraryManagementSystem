package com.thoughtworks.repositories;

import com.thoughtworks.models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuration/services-config.xml")
@Transactional
public class BookRepositoryTest {

  @Autowired
  private BookRepository repository;

  @Test
  public void getBook() {
    Book book = new Book();
    book.setName("TestBook");
    book.setAuthor("TestAuthor");
    book.setCategory("TestCategory");
    book.setVendor("TestVendor");
    repository.save(book);

    Book found = repository.findOne(book.getId());

    assertThat(found, is(equalTo(book)));
    assertThat(found.getId(),is(book.getId()));
    assertThat(found.getName(),is(book.getName()));
    assertThat(found.getAuthor(),is(book.getAuthor()));
    assertThat(found.getCategory(),is(book.getCategory()));
    assertThat(found.getEdition(),is(book.getEdition()));
    assertThat(found.getPrice(),is(book.getPrice()));
    assertThat(found.getVendor(),is(book.getVendor()));
    assertThat(found.getCreatedDate(),is(book.getCreatedDate()));
    assertThat(found.getCreatedBy(),is(book.getCreatedBy()));
    assertThat(found.getUpdatedDate(),is(book.getUpdatedDate()));
    assertThat(found.getUpdatedBy(),is(book.getUpdatedBy()));
    assertThat(found.getIsActive(),is(book.getIsActive()));
    assertThat(found.getBookDetails(),is(book.getBookDetails()));
  }
}
