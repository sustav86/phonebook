package org.sustav.springmvc.entity.person;

import org.sustav.springmvc.entity.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/22
 */
@Entity
@Table(name = "persons")
public class Person {
    @Id @GeneratedValue
    private Long id;
    @NotEmpty(message = "{firstName.notempty}")
    @Size(min=2, max=30, message = "{firstName.size}")
    private String firstName;
    private String lastName;
//    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy="person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phoneNumbers;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addPhone(Phone phone) {
        if (phoneNumbers == null) {
            phoneNumbers = new ArrayList<>();
        }
        phoneNumbers.add(phone);
    }
}
