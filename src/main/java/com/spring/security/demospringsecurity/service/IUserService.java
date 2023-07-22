package com.spring.security.demospringsecurity.service;

import com.spring.security.demospringsecurity.model.User;
import com.spring.security.demospringsecurity.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface IUserService extends UserDetailsService {

    User saveUser(UserRegistrationDto registrationDto) throws Exception;
}
