package com.spring.security.demospringsecurity.web;

import com.spring.security.demospringsecurity.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mehran on 7/22/2023
 */
@Controller
@RequestMapping("/api/")
public class ApplicationController {

    @GetMapping("/index")
    public String showRegistrationForm() {
        return "index";
    }
}
