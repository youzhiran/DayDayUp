package com.devyi.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping(path = "/add")
  public void addNewUser(@RequestParam String name, @RequestParam String email) {
    User user = new User();
    user.setName(name);
    user.setEmail(email);
    userRepository.save(user);
  }

  @GetMapping(path = "/all")
  @ResponseBody
  public Iterable<User> getAllUser() {
    return userRepository.findAll();
  }
}
