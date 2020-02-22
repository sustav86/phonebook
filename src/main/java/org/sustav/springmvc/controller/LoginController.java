package org.sustav.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Anton Sustavov
 * @since 2020/02/21
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(ModelAndView model) {
        model.setViewName("login");

        return model;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView model) {
        model.setViewName("logout");

        return model;
    }
}
