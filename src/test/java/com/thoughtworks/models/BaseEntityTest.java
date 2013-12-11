package com.thoughtworks.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuration/services-config.xml")
public class BaseEntityTest {

  @Test
  public void shouldReturnTrueIfIdIsNull() throws Exception {
    BaseEntity baseEntity = new BaseEntity();
    assertTrue(baseEntity.isNew());
    assertNull(baseEntity.getId());
  }

  @Test
  public void shouldReturnFalseIfIdIsNotNull() throws Exception {
    BaseEntity baseEntity = new BaseEntity();
    baseEntity.setId(1l);
    assertFalse(baseEntity.isNew());
    assertThat(baseEntity.getId(), is(1l));
  }
}
