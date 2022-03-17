package com.osf.lojaosf.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    @ManyToOne
    @NotNull
    private Stock stock;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private final List<Staff> staff = new ArrayList<>();

    @ManyToMany
    private List<Product> productList = new ArrayList<Product>();

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<Order>();

    public Store() {
    }

    public Store(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}