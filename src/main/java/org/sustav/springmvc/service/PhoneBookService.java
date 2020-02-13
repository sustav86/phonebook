package org.sustav.springmvc.service;

import org.sustav.springmvc.dto.HumanDto;

import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/12
 */
public interface PhoneBookService {
    long create(HumanDto humanDto);
    List<HumanDto> showAll();
}
