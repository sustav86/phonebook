package org.sustav.springmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.sustav.springmvc.config.HibernateConfiguration;
import org.sustav.springmvc.config.WebConfiguration;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
public class WebApplicationInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfiguration.class, HibernateConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
