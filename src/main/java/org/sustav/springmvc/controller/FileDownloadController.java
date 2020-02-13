package org.sustav.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sustav.springmvc.service.PhoneBookFileService;

/**
 * @author Anton Sustavov
 * @since 2020/02/13
 */
@Controller
@RequestMapping("/download")
public class FileDownloadController {

    @Autowired
    private PhoneBookFileService phoneBookFileService;

    @RequestMapping(value = "/pdf", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> download() throws Exception{

//        FileOutputStream pdf = phoneBookFileService.createPdf();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentLength(pdf.);
//        ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
//                new InputStreamResource(pdf.get), headers, HttpStatus.OK);

        return null;

    }
}
