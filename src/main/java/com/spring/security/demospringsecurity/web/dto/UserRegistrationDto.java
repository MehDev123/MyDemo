package com.spring.security.demospringsecurity.web.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Mehran on 7/17/2023
 */
@Getter
@Setter
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
