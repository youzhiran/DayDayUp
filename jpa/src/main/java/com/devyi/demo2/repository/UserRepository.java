package com.devyi.demo2.repository;

import com.devyi.demo2.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
