package org.sustav.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/11
 */
@Entity
public class Human {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private List<String> phone;

}
