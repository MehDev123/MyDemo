package com.spring.security.demospringsecurity.web;

import com.spring.security.demospringsecurity.exception.ApplicationException;
import com.spring.security.demospringsecurity.service.IUserService;
import com.spring.security.demospringsecurity.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mehran on 7/17/2023
 */
@Controller
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private IUserService iUserService;


//    @ModelAttribute
//    public UserRegistrationDto userRegistrationDto() {
//        return new UserRegistrationDto();
//    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, Model model) throws Exception {
        try {
            iUserService.saveUser(registrationDto);
            return "redirect:/registration?success";
        } catch (ApplicationException a) {
            model.addAttribute("errorMessage",  a.getErrorCode());
            return "redirect:/registration?error";
        }

    }
}
