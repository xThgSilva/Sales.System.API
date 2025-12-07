package com.sales.system.dto;

import java.time.LocalDate;
import com.sales.system.entities.Sale;

public class SaleDTO {
	private Long id;
	private LocalDate saleDate;
	private float totalValue;
	
	public SaleDTO() {
	}
	
	public SaleDTO(Long id, LocalDate saleDate, float totalValue) {
		this.id = id;
		this.saleDate = saleDate;
		this.totalValue = totalValue;
	}
	
	public SaleDTO(Sale entity) {
		this.id = entity.getId();
		this.saleDate = entity.getSaleDate();
		this.totalValue = entity.getTotalValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}
}
