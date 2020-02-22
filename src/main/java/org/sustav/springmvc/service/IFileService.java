package org.sustav.springmvc.service;

import java.io.ByteArrayInputStream;

/**
 * @author Anton Sustavov
 * @since 2020/02/13
 */
public interface IFileService {
    ByteArrayInputStream createPdf() throws Exception;
}
