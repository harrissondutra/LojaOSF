package com.osf.lojaosf.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stocks {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "stocks" )
    private List<Stores> storesList;

    @OneToMany
    private List<Products> products;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Stores> getStoresList() {
        return storesList;
    }

    public void setStoresList(List<Stores> storesList) {
        this.storesList = storesList;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}