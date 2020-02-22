package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sustav.springmvc.entity.Phone;
import org.sustav.springmvc.entity.PhoneCompany;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.service.UserService;
import org.sustav.springmvc.wrapper.DetailsWrapper;

/**
 * @author Anton Sustavov
 * @since 2020/02/20
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView model) {
        model.addObject("user", new User());
        DetailsWrapper detailsWrapper = new DetailsWrapper();
        detailsWrapper.add(new Phone());
        detailsWrapper.add(new Phone());
        model.addObject("phoneNumbers", detailsWrapper.getPhoneNumbers());
        model.setViewName("registration");

        return model;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute("user") User user,
                                @ModelAttribute("detailsWrapper") DetailsWrapper detailsWrapper,
                                BindingResult bindingResult, ModelAndView model) {

        model.setViewName("registration");
        if (bindingResult.hasErrors()) {
            return model;
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addObject("passwordError", "Password doesn't mach");
            return model;
        }
        if (!detailsWrapper.getPhoneNumbers().isEmpty()) {
            mergeDetails(user, detailsWrapper);
        }
        if (!userService.saveUser(user)){
            model.addObject("usernameError", "User already exists.");
            return model;
        }
        model.setViewName("redirect:/");

        return model;
    }

    private void mergeDetails(User user, DetailsWrapper detailsWrapper) {
        user.setPhones(detailsWrapper.getPhoneNumbers());
        detailsWrapper.getPhoneNumbers().forEach(phone -> {
            phone.setUser(user);
            PhoneCompany phoneCompany;
            if ((phoneCompany = phone.getPhoneCompany()) != null) {
                phoneCompany.setPhone(phone);
            }
        });
    }
}
