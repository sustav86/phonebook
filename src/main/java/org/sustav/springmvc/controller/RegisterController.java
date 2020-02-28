package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sustav.springmvc.entity.Phone;
import org.sustav.springmvc.entity.PhoneCompany;
import org.sustav.springmvc.entity.Role;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.entity.UserAccount;
import org.sustav.springmvc.service.UserService;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anton Sustavov
 * @since 2020/02/20
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView registration(ModelAndView model) {
        User userForm = new User();
        userForm.setPhones(new ArrayList<Phone>(){{add(new Phone()); add(new Phone());}});
        model.addObject("userForm", userForm);
        model.setViewName("register");

        return model;
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute("userForm") User user, BindingResult userBindingResult, ModelAndView model) {

        model.setViewName("register");
        if (userBindingResult.hasErrors() ) {
            return model;
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addObject("passwordError", "Password doesn't mach");
            return model;
        }

        mergeDetails(user);

        if (!userService.saveUser(user)){
            model.addObject("usernameError", "User already exists.");
            return model;
        }
        model.setViewName("redirect:/");

        return model;
    }

    private void mergeDetails(User user) {
        if (user.isManager()) {
            user.setRoles(Collections.singleton(new Role("ROLE_BOOKING_MANAGER")));
        } else {
            user.setRoles(Collections.singleton(new Role("ROLE_RESGISTERED_USER")));
        }
        user.getPhones().forEach(phone -> {
            phone.setUser(user);
            PhoneCompany phoneCompany;
            UserAccount userAccount;
            if ((phoneCompany = phone.getPhoneCompany()) != null) {
                phoneCompany.setPhone(phone);
                userAccount = phoneCompany.getUserAccount();
                userAccount.setPhoneCompany(phoneCompany);
                phoneCompany.setUserAccount(userAccount);
                userAccount.setPhoneCompany(phoneCompany);
            }
        });
    }
}
