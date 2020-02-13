package org.sustav.springmvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.Set;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Entity
@Table(name = "human")
public class Human {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @OneToMany(mappedBy="human", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Phone> phone;

    public Human() {
    }

    public Human(String name, String surname, Set<Phone> phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Phone> getPhone() {
        return phone;
    }

    public void setPhone(Set<Phone> phone) {
        this.phone = phone;
    }
}
