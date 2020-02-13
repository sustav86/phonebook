package org.sustav.springmvc.service;

import java.io.FileOutputStream;

/**
 * @author Anton Sustavov
 * @since 2020/02/13
 */
public interface PhoneBookFileService {
    FileOutputStream createPdf() throws Exception;
}
