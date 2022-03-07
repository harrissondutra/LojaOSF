package com.osf.lojaosf.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private int model_year;
	private Double price;

	@ManyToOne(fetch = FetchType.EAGER)
	private Brand brand = new Brand();

	@ManyToOne()
	private Category category = new Category();

	@ManyToOne
	private Stock stock;

	public Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	public Product(String name, Brand brand, Category category) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
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

	public Brand getBrands() {
		return brand;
	}

	public void setBrands(Brand brand) {
		this.brand = brand;
	}

	

	public Category getCategory() {
		category.setProductsList(null);
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

	

}