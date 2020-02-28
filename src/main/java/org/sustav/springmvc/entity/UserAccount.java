package org.sustav.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Anton Sustavov
 * @since 2020/02/26
 */
@Entity
@Table(name = "user_accounts")
public class UserAccount {
    @Id @GeneratedValue
    private Long id;
    private BigDecimal amount;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PhoneCompany phoneCompany;

    public UserAccount() {
        amount = new BigDecimal(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PhoneCompany getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(PhoneCompany phoneCompany) {
        this.phoneCompany = phoneCompany;
    }
}
