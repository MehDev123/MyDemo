package com.spring.security.demospringsecurity.service.imple;

import com.spring.security.demospringsecurity.exception.ApplicationException;
import com.spring.security.demospringsecurity.model.Role;
import com.spring.security.demospringsecurity.model.User;
import com.spring.security.demospringsecurity.repository.IUserRepository;
import com.spring.security.demospringsecurity.service.IUserService;
import com.spring.security.demospringsecurity.web.dto.UserRegistrationDto;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

/**
 * Created by Mehran on 7/17/2023
 */
@Service
public class UserService implements IUserService {


    private IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User saveUser(UserRegistrationDto registrationDto) throws Exception {
        try {
            User user = new User(registrationDto.getFirstName(),
                    registrationDto.getLastName(),
                    registrationDto.getEmail(),
                    registrationDto.getPassword(), Arrays.asList(new Role("USER_ROLE")));

            return iUserRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new ApplicationException("100","Your Email already inserted to Database");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=iUserRepository.findUserByEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("User not exist!");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),null);
    }
}
