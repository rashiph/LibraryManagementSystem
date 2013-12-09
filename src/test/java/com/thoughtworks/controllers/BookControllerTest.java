package com.thoughtworks.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:configuration/mvc-dispatcher-config.xml", "classpath:configuration/services-config.xml"})
public class BookControllerTest {

  @Autowired
  protected WebApplicationContext wac;
  protected MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = webAppContextSetup(this.wac).build();
  }

  @Test
  public void initCreationOfBook() throws Exception {

    MvcResult mvcResult = mockMvc.perform(get("/new")).andExpect(status().isFound()).andReturn();
    assertThat(mvcResult.getModelAndView().getViewName(), is("redirect:/"));
    assertThat(mvcResult.getModelAndView().getModel().size(), is(0));
  }

  @Test
  public void index() {

  }
}
