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
@Table(name = "phone")
public class Phone {
    @Id @GeneratedValue
    private Long id;
    private int kod;
    private int number;
    @ManyToOne
    @JoinColumn(name="human_id", nullable=false)
    private Human human;
    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PhoneCompany phoneCompany;

    public Phone(int kod, int number, PhoneCompany phoneCompany) {
        this.kod = kod;
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

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
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
}
