package com.osf.lojaosf.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "stock")
    private List<Store> storeList;

    @OneToMany
    private List<Product> products;

    public Stock() {
    }

    public static Product checkProductStock() {
        Product product = new Product();
        if(product.getId() == null){
            throw new IllegalArgumentException("Is necessary one product to create a Stock");
        }
        return product;
    }

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