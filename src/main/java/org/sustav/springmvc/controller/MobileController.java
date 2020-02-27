package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sustav.springmvc.entity.PhoneCompany;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.exception.NotEnoughMoney;
import org.sustav.springmvc.service.IMobileService;
import org.sustav.springmvc.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.Optional;

/**
 * @author Anton Sustavov
 * @since 2020/02/26
 */
@Controller
@RequestMapping("/mobiles")
public class MobileController {

    @Autowired
    private UserService userService;
    @Autowired
    private IMobileService mobileService;

    @PostMapping
    public ModelAndView changeMobileCompany(@ModelAttribute("id") Long id, @ModelAttribute("name") String name,
                                            ModelAndView model, Principal principal) {
        Optional<PhoneCompany> findById = mobileService.findById(id);
        PhoneCompany phoneCompany = findById.orElseThrow(() -> new EntityNotFoundException(id.toString()));
        if (phoneCompany.getName().equals(name)) {
            return model;
        }
        phoneCompany.setName(name);
        try {
            mobileService.changeMobileOperator(phoneCompany);
        } catch (NotEnoughMoney notEnoughMoney) {
            User userByName = userService.findUserByName(principal.getName());
            model.setViewName("changeMobileCompany");
            model.addObject("notEnoughMoney", "You haven't enough money!");
            model.addObject("user", userByName);
            return model;
        }

        model.setViewName("redirect:/user/" + principal.getName());

        return model;
    }

    @GetMapping("/{user_id}")
    public ModelAndView getMobileCompany(@PathVariable("user_id") Long id, ModelAndView model) {
        User user = userService.findUserById(id);
        model.addObject("user", user);
        model.setViewName("changeMobileCompany");

        return model;
    }
}
