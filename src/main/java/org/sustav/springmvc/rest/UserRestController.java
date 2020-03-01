package org.sustav.springmvc.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.service.UserService;

import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/28
 */
@RestController
@RequestMapping("users-rest/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public @ResponseBody User getOne(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public Page<User> getAll(Pageable pageable) {
        return userService.allUsers(pageable);
    }

    @GetMapping(produces = "application/pdf")
    public String getAllUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "manager";
    }

    @PutMapping(value = "/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        User userById = userService.findUserById(id);
        BeanUtils.copyProperties(user, userById);
        return userService.saveUser(userById);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
