package org.sustav.springmvc.dto;

import java.util.Set;

/**
 * @author Anton Sustavov
 * @since 2020/02/21
 */
public class UserDto {
    private Long id;
    private String username;
    private String surname;
    private Set<RoleDto> roles;
    private Set<PhoneDto> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public Set<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneDto> phones) {
        this.phones = phones;
    }
}
