package org.sustav.springmvc.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author Anton Sustavov
 * @since 2020/02/28
 */
public class PdfViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        PdfView view = new PdfView();
        return view;
    }
}
