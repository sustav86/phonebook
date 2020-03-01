package org.sustav.springmvc.converter;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.sustav.springmvc.entity.Phone;
import org.sustav.springmvc.entity.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/28
 */
public class UserConverter implements HttpMessageConverter<User> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return true;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_PDF);
        return mediaTypes;
    }

    @Override
    public User read(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(User user, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfPTable table = new PdfPTable(6);

        table.addCell("Username");
        table.addCell("First name");
        table.addCell("Last name");
        table.addCell("Country code");
        table.addCell("Number");
        table.addCell("Company");

        List<Phone> phones = user.getPhones();
        for (Phone phone : phones) {
            table.addCell(user.getUsername());
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell(String.valueOf(phone.getCountryCode()));
            table.addCell(String.valueOf(phone.getNumber()));
            table.addCell(phone.getPhoneCompany().getName());
        }

        try (OutputStream outputStream = outputMessage.getBody()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            document.close();
            outputStream.write(out.toByteArray());
        } catch (Exception ex) {
        }
    }

}
