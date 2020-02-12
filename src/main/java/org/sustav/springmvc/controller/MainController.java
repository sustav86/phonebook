package org.sustav.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.dto.HumanDto;
import org.sustav.springmvc.entity.Human;
import org.sustav.springmvc.service.MultipartFileService;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Controller
public class MainController {

    @Autowired
    private MultipartFileService multipartFileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws Exception {

//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//
//        InputStream inputStream = null;
//        try {
//            inputStream = file.getInputStream();
//            HumanDto humanDto = mapper.readValue(inputStream, HumanDto.class);
//            System.out.println(humanDto);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        HumanDto humanDto = multipartFileService.fromFileToObjectDto(file);
        System.out.println(humanDto);

        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }
}
