package org.sustav.springmvc.controller;

import org.modelmapper.ModelMapper;
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
import org.sustav.springmvc.dto.UserDto;
import org.sustav.springmvc.entity.user.User;
import org.sustav.springmvc.service.IMultipartFile;
import org.sustav.springmvc.service.IFileService;
import org.sustav.springmvc.service.UserService;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

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
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return "redirect:/manager";
        }
        List<User> users = IMultipartFile.fromFileToUser(file);
        userService.saveAll(users);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/download/pdf", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> download() throws Exception{
        ByteArrayInputStream pdf = iFileService.createPdf();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(new InputStreamResource(pdf), headers, HttpStatus.OK);
    }

    private User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private List<User> convertToEntities(List<UserDto> userDtos) {
        return userDtos.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }
}
