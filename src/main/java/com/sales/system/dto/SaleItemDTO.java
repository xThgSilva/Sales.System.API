package com.sales.system.dto;

import com.sales.system.entities.SaleItem;

public class SaleItemDTO {
	private Long id;
	private int amount;
	private float unitPrice;
	
	public SaleItemDTO() {
	}

	public SaleItemDTO(Long id, int amount, float unitPrice) {
		this.id = id;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}
	
	public SaleItemDTO(SaleItem entity) {
		this.id = entity.getId();
		this.amount = entity.getAmount();
		this.unitPrice = entity.getUnitPrice();
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
}
