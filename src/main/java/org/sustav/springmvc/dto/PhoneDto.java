package org.sustav.springmvc.dto;

public class PhoneDto {
    private int countryCode;
    private int number;
    private PhoneCompanyDto phoneCompany;

    public PhoneDto() {
    }

    public PhoneDto(int countryCode, int number, PhoneCompanyDto phoneCompany) {
        this.countryCode = countryCode;
        this.number = number;
        this.phoneCompany = phoneCompany;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PhoneCompanyDto getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(PhoneCompanyDto phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    @Override
    public String toString() {
        return "PhoneDto{" +
                "countryCode=" + countryCode +
                ", number=" + number +
                ", phoneCompany=" + phoneCompany +
                '}';
    }
}
