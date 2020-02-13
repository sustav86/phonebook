package org.sustav.springmvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Entity
@Table(name = "phone_company")
public class PhoneCompany {
    @Id @GeneratedValue
    private Long id;
    private String name;
//    @OneToOne(fetch = FetchType.LAZY)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", nullable = false)
    private Phone phone;

    public PhoneCompany(String name) {
        this.name = name;
    }

    public PhoneCompany() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
