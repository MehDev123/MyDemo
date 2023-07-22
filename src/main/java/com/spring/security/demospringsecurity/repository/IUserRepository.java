package com.spring.security.demospringsecurity.repository;

import com.spring.security.demospringsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);
}
