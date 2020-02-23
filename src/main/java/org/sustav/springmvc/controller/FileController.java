package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.entity.PhoneCompany;
import org.sustav.springmvc.entity.Role;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.service.IFileService;
import org.sustav.springmvc.service.IMultipartFile;
import org.sustav.springmvc.service.UserService;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/13
 */
@Controller
public class FileController {
    @Autowired
    private IFileService iFileService;
    @Autowired
    private IMultipartFile IMultipartFile;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return "redirect:/manager/users";
        }
        List<User> users = IMultipartFile.fromFileToUser(file);
        users.forEach(user -> mergeDetails(user));
        userService.saveAll(users);
        return "redirect:/manager/users";
    }

    @RequestMapping(value = "/download/pdf", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> download() throws Exception{
        ByteArrayInputStream pdf = iFileService.createPdf();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(new InputStreamResource(pdf), headers, HttpStatus.OK);
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
            if ((phoneCompany = phone.getPhoneCompany()) != null) {
                phoneCompany.setPhone(phone);
            }
        });
    }

}
