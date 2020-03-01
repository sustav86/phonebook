package org.sustav.springmvc.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.sustav.springmvc.entity.Phone;
import org.sustav.springmvc.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Anton Sustavov
 * @since 2020/02/29
 */
public class PdfView extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<User> users = (List<User>) model.get("users");

        PdfPTable table = new PdfPTable(6);

        table.addCell("Username");
        table.addCell("First name");
        table.addCell("Last name");
        table.addCell("Country code");
        table.addCell("Number");
        table.addCell("Company");

        for (User user : users){
            List<Phone> phones = user.getPhones();
            for (Phone phone : phones) {
                table.addCell(user.getUsername());
                table.addCell(user.getFirstName());
                table.addCell(user.getLastName());
                table.addCell(String.valueOf(phone.getCountryCode()));
                table.addCell(String.valueOf(phone.getNumber()));
                table.addCell(phone.getPhoneCompany().getName());
            }
        }

        document.add(table);
    }
}
