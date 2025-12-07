package com.sales.system.dto;

import com.sales.system.entities.Sale;
import com.sales.system.entities.SaleItem;

public class SaleItemDTO {
	private Long id;
	private Long productId;
	private Sale sale;
	private int amount;
	private float unitPrice;
	
	public SaleItemDTO() {
	}

	public SaleItemDTO(Long id, Long productId, Sale sale, int amount, float unitPrice) {
		this.id = id;
		this.productId = productId;
		this.sale = sale;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}

	public SaleItemDTO(SaleItem entity) {
		this.id = entity.getId();
		this.amount = entity.getAmount();
		this.unitPrice = entity.getUnitPrice();
		this.productId = entity.getProduct().getId();
		this.sale = entity.getSale();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
}
