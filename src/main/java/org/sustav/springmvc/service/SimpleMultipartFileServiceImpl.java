package org.sustav.springmvc.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.dto.HumanDto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SimpleMultipartFileServiceImpl implements MultipartFileService {
    @Override
    public HumanDto fromFileToObjectDto(MultipartFile multipartFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        InputStream inputStream = multipartFile.getInputStream();
        return mapper.readValue(inputStream, HumanDto.class);
    }
}
