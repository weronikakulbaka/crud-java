package com.weronika.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Pattern(regexp = "[a-zA-Z]{2,30}", message = "Podaj poprawnie nazwisko od 2 do 30 znakow")
    @Column(name = "firstName")
    private String firstName;
    
    @Pattern(regexp = "[a-zA-Z]{2,30}", message = "Podaj poprawnie nazwisko od 2 do 30 znakow")
    @Column(name = "lastName")
    private String lastName;
    
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}", message = "Podaj poprawnie email")
    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
