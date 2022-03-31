package com.osf.lojaosf.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade de cadastro ds lojas
 */
@Entity
@Table(name = "stores")
public class Store extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    @ManyToOne
    @JsonIgnoreProperties("storeList")
    @NotNull
    private Stock stock;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("store")
    private final List<Staff> staff = new ArrayList<>();

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> productsList;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<Order>();

    public Store() {
    }

    public boolean changeStockStore(Staff staff, Store store){
        if (staff.isManager()){
            store.setStock(stock);
        }
        return false;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}