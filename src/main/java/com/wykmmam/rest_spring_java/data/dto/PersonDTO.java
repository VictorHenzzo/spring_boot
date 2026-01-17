package com.wykmmam.rest_spring_java.data.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable {
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    public PersonDTO() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonDTO person = (PersonDTO) o;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstName(),
                person.getFirstName()
        ) && Objects.equals(
                getLastName(),
                person.getLastName()
        ) && Objects.equals(
                getAddress(),
                person.getAddress()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getFirstName(),
                getLastName(),
                getAddress()
        );
    }
}
