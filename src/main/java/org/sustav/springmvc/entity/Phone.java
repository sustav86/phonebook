package org.sustav.springmvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Entity
@Table(name = "phones")
public class Phone {
    @Id @GeneratedValue
    private Long id;
    private int countryCode;
    private int number;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private PhoneCompany phoneCompany;

    public Phone(int countryCode, int number, PhoneCompany phoneCompany) {
        this.countryCode = countryCode;
        this.number = number;
        this.phoneCompany = phoneCompany;
    }

    public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int kod) {
        this.countryCode = kod;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PhoneCompany getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(PhoneCompany phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
