package org.sustav.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Entity
public class PhoneCompany {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
