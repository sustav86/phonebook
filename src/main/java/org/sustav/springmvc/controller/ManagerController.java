package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sustav.springmvc.entity.Phone;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.service.UserService;

import java.security.Principal;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/23
 */
@Controller
public class ManagerController {

    @Autowired
    private UserService userService;

    @GetMapping("/manager/users")
    public ModelAndView users(ModelAndView model) {
        List<User> users = userService.allUsers();
        model.addObject("users", users);
        model.setViewName("manager");

        return model;
    }

    @GetMapping("/manager/users/{id}")
    public ModelAndView user(@PathVariable("id") Long id, ModelAndView model) {
        User user = userService.findUserById(id);
        model.addObject("user", user);
        model.setViewName("update");

        return model;
    }

    @PostMapping("/manager/users/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute("userName") String userName,
                               @ModelAttribute("user") User updateUser, @ModelAttribute("_method") String method,
                               ModelAndView model, Principal principal) {
        if (method.equals("put")) {
            updateUser(id, updateUser, model);
        } else if (method.equals("delete")) {
            deleteUser(id, userName, model, principal);
        }

        return model;
    }

    private void deleteUser(Long id, String userName, ModelAndView model, Principal principal) {
        userService.deleteUser(id);
        if (principal.getName().equals(userName)) {
            model.setViewName("redirect:/logout");
        } else {
            model.addObject("users", userService.allUsers());
            model.setViewName("manager");
        }
    }

    private void updateUser(Long id, User updateUser, ModelAndView model) {
        User user = userService.findUserById(id);
        user.setUsername(updateUser.getUsername());
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPassword(updateUser.getPassword());
        List<Phone> phones = user.getPhones();
        List<Phone> phonesUpd = updateUser.getPhones();
        for (int i = 0; i < phones.size(); i++) {
            phones.get(i).setCountryCode(phonesUpd.get(i).getCountryCode());
            phones.get(i).setNumber(phonesUpd.get(i).getNumber());
            phones.get(i).getPhoneCompany().setName(phonesUpd.get(i).getPhoneCompany().getName());
            phones.get(i).getPhoneCompany().setPrice(phonesUpd.get(i).getPhoneCompany().getPrice());
            phones.get(i).getPhoneCompany().getUserAccount().setAmount(phonesUpd.get(i).getPhoneCompany().getUserAccount().getAmount());
        }
        userService.updateUser(user);
        model.addObject("users", userService.allUsers());
        model.setViewName("manager");
    }

}
