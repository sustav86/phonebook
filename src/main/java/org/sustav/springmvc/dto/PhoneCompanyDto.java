package org.sustav.springmvc.dto;

public class PhoneCompanyDto {
    private String name;

    public PhoneCompanyDto() {
    }

    public PhoneCompanyDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PhoneCompanyDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
