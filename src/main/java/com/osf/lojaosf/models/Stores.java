package com.osf.lojaosf.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
public class Stores extends Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String address;
    private String name;

    @ManyToOne
    private Stocks stocks;

    @ManyToMany
    private List<Products> productsList = new ArrayList<Products>();


    public Stores(String phone, String email, String street, String city, String state, String zip_code, String address, String name) {
        super(phone, email, street, city, state, zip_code);
        this.address = address;
        this.name = name;
    }

    public Stores() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}