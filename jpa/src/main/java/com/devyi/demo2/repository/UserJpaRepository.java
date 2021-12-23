package com.devyi.demo2.repository;

import com.devyi.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
