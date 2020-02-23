package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.service.UserService;

/**
 * @author Anton Sustavov
 * @since 2020/02/21
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{username}")
    public ModelAndView user(@PathVariable("username") String username, ModelAndView model) {
        User user = userService.findUserByName(username);
        model.addObject("user", user);
        model.setViewName("user");

        return model;
    }

    @PutMapping("/user")
    public ModelAndView user(@ModelAttribute("user") User user, ModelAndView model) {
        userService.saveUser(user);
        model.setViewName("manager");

        return model;
    }


}
