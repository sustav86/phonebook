package org.sustav.springmvc.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.dto.UserDto;
import org.sustav.springmvc.entity.user.User;

import java.io.InputStream;
import java.util.List;

@Service
public class MultipartFileService implements IMultipartFile {
    @Override
    public List<UserDto> fromFileToUserDto(MultipartFile multipartFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        InputStream inputStream = multipartFile.getInputStream();
        return mapper.readValue(inputStream, new TypeReference<List<UserDto>>(){});
    }

    @Override
    public List<User> fromFileToUser(MultipartFile multipartFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        InputStream inputStream = multipartFile.getInputStream();
        return mapper.readValue(inputStream, new TypeReference<List<User>>(){});
    }
}
