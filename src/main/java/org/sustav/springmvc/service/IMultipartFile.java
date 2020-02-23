package org.sustav.springmvc.service;

import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.entity.User;

import java.util.List;

public interface IMultipartFile {
    List<User> fromFileToUser(MultipartFile multipartFile) throws Exception;
}
