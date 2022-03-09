package com.osf.lojaosf.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String firstName;
    private String lastName;



    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, String phone, String email, String street, String city, String state, String zip_code) {
        super(phone, email, street, city, state, zip_code);
        this.firstName = firstName;
        this.lastName = lastName;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


}