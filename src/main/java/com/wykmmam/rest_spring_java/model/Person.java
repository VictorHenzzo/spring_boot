package com.wykmmam.rest_spring_java.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            length = 80
    ) private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            length = 80
    ) private String lastName;

    @Column(
            nullable = false,
            length = 150
    ) private String address;

    public Person() {
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
        Person person = (Person) o;
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
