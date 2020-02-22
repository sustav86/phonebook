package org.sustav.springmvc.dto;

public class PhoneDto {
    private int countryCode;
    private int number;
    private PhoneCompanyDto phoneCompany;

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

}
