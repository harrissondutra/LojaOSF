package com.osf.lojaosf.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store extends Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String address;
    private String name;

    @ManyToOne
    private Stock stock;

    @ManyToMany
    private List<Product> productList = new ArrayList<Product>();


    public Store(String phone, String email, String street, String city, String state, String zip_code, String address, String name) {
        super(phone, email, street, city, state, zip_code);
        this.address = address;
        this.name = name;
    }

    public Store() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stock getStocks() {
        return stock;
    }

    public void setStocks(Stock stock) {
        this.stock = stock;
    }

    public List<Product> getProductsList() {
        return productList;
    }

    public void setProductsList(List<Product> productList) {
        this.productList = productList;
    }
}