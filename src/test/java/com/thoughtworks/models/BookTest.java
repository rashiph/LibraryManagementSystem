package com.thoughtworks.models;

import com.thoughtworks.infrastructure.InvalidType;
import com.thoughtworks.maker.BookMaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.Validator;

import static com.thoughtworks.maker.BookMaker.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuration/services-config.xml")
public class BookTest {

  @Autowired
  private Validator validator;

  @Test
  public void bookNameCanNotBeEmpty() {
    InvalidType model = new InvalidType(BookMaker.Book, name, "", validator);
    assertThat(model.isValid(), is(false));
  }

  @Test
  public void bookAuthorCanNotBeEmpty() {
    InvalidType model = new InvalidType(BookMaker.Book, author, "", validator);
    assertThat(model.isValid(), is(false));
  }

  @Test
  public void bookCategoryCanNotBeEmpty() {
    InvalidType model = new InvalidType(BookMaker.Book, category, "", validator);
    assertThat(model.isValid(), is(false));
  }

  @Test
  public void bookVendorCanNotBeEmpty() {
    InvalidType model = new InvalidType(BookMaker.Book, vendor, "", validator);
    assertThat(model.isValid(), is(false));
  }
}
