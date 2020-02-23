package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sustav.springmvc.entity.person.Person;
import org.sustav.springmvc.entity.person.Phone;
import org.sustav.springmvc.entity.person.PhoneCompany;
import org.sustav.springmvc.entity.user.User;
import org.sustav.springmvc.service.UserService;
import org.sustav.springmvc.util.ViewName;

import javax.validation.Valid;

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
        Person newPerson = new Person();
        newPerson.addPhone(new Phone());
        newPerson.addPhone(new Phone());
        model.addObject("person", newPerson);
        model.setViewName(ViewName.REGISTRATION);

        return model;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute("user") @Valid User user,
                                BindingResult bindingResultUser,
                                @ModelAttribute("person") @Valid Person person,
                                BindingResult bindingResultPerson,
                                ModelAndView model) {

        model.setViewName(ViewName.REGISTRATION);
        if (bindingResultUser.hasErrors() || bindingResultPerson.hasErrors()) {
            return model;
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addObject("passwordError", "Password doesn't mach");
            return model;
        }

        mergeDetails(user, person);

        if (!userService.saveUser(user)){
            model.addObject("usernameError", "User already exists.");
            return model;
        }
        model.setViewName(ViewName.ROOT);

        return model;
    }

    private void mergeDetails(User user, Person person) {
//        user.setPerson(person);
//        person.setUser(user);
        person.getPhoneNumbers().forEach(phone -> {
            phone.setPerson(person);
            PhoneCompany phoneCompany;
            if ((phoneCompany = phone.getPhoneCompany()) != null) {
                phoneCompany.setPhone(phone);
            }
        });
    }
}
