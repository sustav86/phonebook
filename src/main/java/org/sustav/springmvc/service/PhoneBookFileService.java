package org.sustav.springmvc.service;

import java.io.ByteArrayInputStream;

/**
 * @author Anton Sustavov
 * @since 2020/02/13
 */
public interface PhoneBookFileService {
    ByteArrayInputStream createPdf() throws Exception;
}
