package org.sustav.springmvc.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.sustav.springmvc.dto.UserDto;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anton Sustavov
 * @since 2020/02/21
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/user/{username}")
    public ModelAndView user(ModelAndView model, @PathVariable("username") String username, Principal principal) {
        User userByName = userService.findUserByName(username);
        model.addObject("user", convertToDto(userByName));
        model.setViewName("user");

        return model;
    }

    @GetMapping("/manager")
    public ModelAndView users(ModelAndView model, Principal principal) {
        List<User> users = userService.allUsers();
        model.addObject("users", convertToDtos(users));
        model.setViewName("manager");

        return model;
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private List<UserDto> convertToDtos(List<User> users) {
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
