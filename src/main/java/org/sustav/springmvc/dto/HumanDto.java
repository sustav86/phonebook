package org.sustav.springmvc.dto;

import java.util.Set;

public class HumanDto {
    private String name;
    private String surname;
    private Set<PhoneDto> phone;

    public HumanDto() {
    }

    public HumanDto(String name, String surname, Set<PhoneDto> phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
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

    public Set<PhoneDto> getPhone() {
        return phone;
    }

    public void setPhone(Set<PhoneDto> phoneDtos) {
        this.phone = phoneDtos;
    }

    @Override
    public String toString() {
        return "HumanDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone=" + phone +
                '}';
    }
}
