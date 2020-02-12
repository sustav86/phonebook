package org.sustav.springmvc.service;

import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.dto.HumanDto;

public interface MultipartFileService {
    HumanDto fromFileToObjectDto(MultipartFile multipartFile) throws Exception;
}
