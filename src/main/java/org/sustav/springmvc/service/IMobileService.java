package org.sustav.springmvc.service;

import org.springframework.stereotype.Service;
import org.sustav.springmvc.entity.PhoneCompany;
import org.sustav.springmvc.exception.NotEnoughMoney;

import java.util.Optional;

/**
 * @author Anton Sustavov
 * @since 2020/02/26
 */
@Service
public interface IMobileService {
    Optional<PhoneCompany> findById(Long id);
    void changeMobileOperator(PhoneCompany phoneCompany) throws NotEnoughMoney;
}
