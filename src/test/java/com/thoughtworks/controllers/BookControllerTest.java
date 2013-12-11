package com.thoughtworks.controllers;

import com.thoughtworks.repositories.BookRepository;
import com.thoughtworks.repositories.BookTransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:configuration/mvc-dispatcher-config.xml", "classpath:configuration/services-config.xml"})
@Transactional
public class BookControllerTest {

  @Autowired
  protected WebApplicationContext wac;
  @Autowired
  private BookRepository repository;
  @Autowired
  private BookTransactionRepository bookTransactionRepository;

  BookController bookController;
  protected MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = webAppContextSetup(this.wac).build();
    this.bookController = new BookController();
  }

  @Test
  public void initCreationOfBook() throws Exception {

    MvcResult mvcResult = mockMvc.perform(get("/new")).andExpect(status().isFound()).andReturn();
    assertThat(mvcResult.getModelAndView().getViewName(), is("redirect:/"));
    assertThat(mvcResult.getModelAndView().getModel().size(), is(0));
  }

  @Test
  public void index() {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);
    when(request.getSession()).thenReturn(session);
    when(session.getAttribute("isLogin")).thenReturn(true);
    Map<String, Object> model = new HashMap<String, Object>();

    bookController.index(model,request);

  }
}
