package com.sales.system.dto;

import com.sales.system.entities.Product;

public class ProductDTO {
	private Long id;
	private String name;
	private float price;
	private int stockQuantity;
	
	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, float price, int stockQuantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.stockQuantity = entity.getStockQuantity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
