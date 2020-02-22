package org.sustav.springmvc.service;

import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.dto.UserDto;
import org.sustav.springmvc.entity.User;

import java.util.List;

public interface IMultipartFile {
    List<UserDto> fromFileToUserDto(MultipartFile multipartFile) throws Exception;
    List<User> fromFileToUser(MultipartFile multipartFile) throws Exception;
}
