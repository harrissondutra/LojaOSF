package com.osf.lojaosf.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private int model_year;
	private Double price;

	@ManyToOne(fetch = FetchType.EAGER)
	private Brands brands = new Brands();

	@ManyToOne
	private Category category;

	@ManyToOne
	private Stocks stock;

	public Products() {
	}

	public Products(String name) {
		this.name = name;
	}

	public Products(String name, Brands brands, Category category) {
		super();
		this.name = name;
		this.brands = brands;
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

	public Brands getBrands() {
		return brands;
	}

	public void setBrands(Brands brands) {
		this.brands = brands;
	}

	

	public void setCategory(Category category) {
		this.category = category;
	}

	public Stocks getStock() {
		return stock;
	}

	public void setStock(Stocks stock) {
		this.stock = stock;
	}

	

}