package com.osf.lojaosf.models.entities;

import javax.persistence.*;
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
    private Stock stock;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private final List<Staff> staff = new ArrayList<>();

    @ManyToMany
    private List<Product> productList = new ArrayList<Product>();

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
}