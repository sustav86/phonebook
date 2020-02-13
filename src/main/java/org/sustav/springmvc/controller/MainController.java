package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.sustav.springmvc.dto.HumanDto;
import org.sustav.springmvc.service.MultipartFileService;
import org.sustav.springmvc.service.PhoneBookService;

import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Controller
public class MainController {
    @Autowired
    private MultipartFileService multipartFileService;
    @Autowired
    private PhoneBookService phoneBookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        List<HumanDto> humanDtos = phoneBookService.showAll();
        model.addAttribute("humanDtos", humanDtos);
        return "index";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return "redirect:/";
        }
        HumanDto humanDto = multipartFileService.fromFileToObjectDto(file);
        phoneBookService.create(humanDto);
        return "redirect:/";
    }
}
