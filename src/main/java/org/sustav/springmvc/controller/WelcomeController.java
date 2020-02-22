package org.sustav.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage(ModelAndView model) {
        model.addObject("title", "Spring Security Tutorial");
        model.addObject("message", "Welcome Page !");
        model.setViewName("welcome");

        return model;
    }

}
