package com.devyi.demo2.controller;


import com.devyi.demo2.entity.User;
import com.devyi.demo2.repository.UserPagingAndSortingRepository;
import com.devyi.demo2.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo2")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserPagingAndSortingRepository userPagingAndSortingRepository;

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

  @GetMapping(path = "/info")
  @ResponseBody
  public Optional<User> findOne(@RequestParam Long id) {
    return userRepository.findById(id);
  }

  @GetMapping(path = "/delete")
  public void delete(@RequestParam Long id) {
    userRepository.deleteById(id);
  }


  /**
   * 验证排序和分页查询方法，Pageable的默认实现类：PageRequest
   *
   * @return
   */
  @GetMapping(path = "/page")
  @ResponseBody
  public Page<User> getAllUserByPage() {
    // springboot2.1.8（含）以上的版本Sort已经不能再实例化了，构造方法已经是私有的
    // 我们可以改用Sort.by获得Sort对象，PageRequest同理
    return userPagingAndSortingRepository.findAll(
        PageRequest.of(1, 20, Sort.by(Sort.Direction.ASC, "name")));
  }

  /**
   * 排序查询方法，使用Sort对象
   *
   * @return
   */
  @GetMapping(path = "/sort")
  public Iterable<User> getAllUserWithSort() {
    return userPagingAndSortingRepository.findAll(
        Sort.by(new Sort.Order(Sort.Direction.ASC, "name")));
  }


}
