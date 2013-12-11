package com.thoughtworks.models;

import com.thoughtworks.infrastructure.InvalidType;
import com.thoughtworks.maker.UserMaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.Validator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuration/services-config.xml")
public class UserTest {

  @Autowired
  private Validator validator;

  @Test
  public void fullNameCanNotBeEmpty() {
    InvalidType model = new InvalidType(UserMaker.User, UserMaker.fullName, "", validator);
    assertThat(model.isValid(), is(false));
  }

 @Test
  public void passwordCanNotBeEmpty() {
    InvalidType model = new InvalidType(UserMaker.User, UserMaker.password, "", validator);
    assertThat(model.isValid(), is(false));
  }
}
