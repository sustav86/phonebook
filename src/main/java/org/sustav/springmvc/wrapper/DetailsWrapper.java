package org.sustav.springmvc.wrapper;

import org.sustav.springmvc.entity.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/21
 */
public class DetailsWrapper {
    private List<Phone> phoneNumbers;

    public DetailsWrapper() {
        this.phoneNumbers = new ArrayList<>();
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void add(Phone phone) {
        this.phoneNumbers.add(phone);
    }

}
