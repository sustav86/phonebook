package org.sustav.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sustav.springmvc.entity.PhoneCompany;
import org.sustav.springmvc.entity.UserAccount;
import org.sustav.springmvc.exception.NotEnoughMoney;
import org.sustav.springmvc.repository.MobileCompanyRepository;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Anton Sustavov
 * @since 2020/02/27
 */
@Service
public class MobileService implements IMobileService {

    @Autowired
    private MobileCompanyRepository mobileCompanyRepository;

    @Override
    public Optional<PhoneCompany> findById(Long id) {
        return mobileCompanyRepository.findById(id);
    }

    @Transactional(rollbackFor = NotEnoughMoney.class)
    @Override
    public void changeMobileOperator(PhoneCompany phoneCompany) throws NotEnoughMoney {
        UserAccount userAccount = phoneCompany.getUserAccount();
        phoneCompany.setPrice(new BigDecimal(10));
        if (phoneCompany.getPrice().compareTo(userAccount.getAmount()) > 0) {
            throw new NotEnoughMoney("Not enough money");
        }
        mobileCompanyRepository.save(phoneCompany);
    }
}
