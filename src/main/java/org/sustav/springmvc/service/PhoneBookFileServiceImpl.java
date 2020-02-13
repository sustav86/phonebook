package org.sustav.springmvc.service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sustav.springmvc.dto.HumanDto;

import java.io.FileOutputStream;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/13
 */
@Service
public class PhoneBookFileServiceImpl implements PhoneBookFileService {
    @Autowired
    private PhoneBookServiceImpl phoneBookService;

    @Override
    public FileOutputStream createPdf() throws Exception {
        Document document = new Document();
        FileOutputStream os = new FileOutputStream("phonebook.pdf");
        PdfWriter.getInstance(document, os);
        List<HumanDto> humanDtos = phoneBookService.showAll();
        document.open();
        for (HumanDto human : humanDtos) {
            document.add(new Chunk(human.toString()));
        }
        document.close();
        return os;
    }
}
