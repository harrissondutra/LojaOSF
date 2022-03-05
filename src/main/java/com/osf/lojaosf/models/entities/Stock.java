package com.osf.lojaosf.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "stock")
    private List<Store> storeList;

    @OneToMany
    private List<Product> products;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Store> getStoresList() {
        return storeList;
    }

    public void setStoresList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}