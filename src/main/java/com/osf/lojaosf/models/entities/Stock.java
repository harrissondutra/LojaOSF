package com.osf.lojaosf.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Entidade de cadastro de estoque
 */
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String codigo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
    @JsonIgnoreProperties("stock")
    private List<Store> storeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
    @JsonIgnore
    private List<Product> productsList;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}