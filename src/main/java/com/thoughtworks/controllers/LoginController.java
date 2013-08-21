package com.thoughtworks.controllers;

import com.thoughtworks.models.User;
import com.thoughtworks.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@NoArgsConstructor
@Controller
@SessionAttributes(types = User.class)
public class LoginController {

  @Autowired
  private UserRepository repository;

//  @Autowired
//  public LoginController( UserRepository repository) {
//    this.repository = repository;
//  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login_request(Map<String, Object> model) {
    User login = new User();
    model.put("login", login);
    return "user/login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@RequestParam("employeeId") Long employeeId, HttpServletRequest request) {
    boolean isAdmin = repository.findOne(employeeId) != null;
    request.getSession().setAttribute("isAdmin", isAdmin);
    return "redirect:/";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request) {
    request.getSession().setAttribute("isAdmin", null);
    return "redirect:/";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String register(Map<String, Object> model) {
    User user = new User();
    model.put("user", user);
    return "user/register";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request) {
    if (result.hasErrors()) {
      return "user/register";
    }
    user.setActive(true);
    this.repository.save(user);

    request.getSession().setAttribute("isLogin", Boolean.TRUE);
    request.getSession().setAttribute("isAdmin", Boolean.FALSE);
    return "redirect:/";

  }
}


