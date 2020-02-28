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
        BigDecimal price = phoneCompany.getPrice();
        BigDecimal amount = userAccount.getAmount();
        if (price.compareTo(amount) > 0) {
            throw new NotEnoughMoney("Not enough money");
        }
        userAccount.setAmount(price.subtract(amount));
        mobileCompanyRepository.save(phoneCompany);
    }
}
