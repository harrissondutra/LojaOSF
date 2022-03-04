package com.osf.lojaosf.models;

import jdk.jfr.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private int model_year;
    private Double price;

    @ManyToOne
    private Brands brands = new Brands();

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private List<Categories> categories = new ArrayList<>();

    @ManyToOne
    private Stocks stock = new Stocks();


    public Products() {
    }

    public Products(String name) {
        this.name = name;
    }

    public Products(String name, Brands brands) {
        this.name = name;
        this.brands = brands;
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

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public Stocks getStock() {
        return stock;
    }

    public void setStock(Stocks stock) {
        this.stock = stock;
    }
}