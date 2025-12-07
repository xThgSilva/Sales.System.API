package com.sales.system.dto;

import java.time.LocalDate;
import java.util.List;
import com.sales.system.entities.Sale;

public class SaleDTO {
	private Long id;
	private Long custumerId;
	private LocalDate saleDate;
	private float totalValue;
	private List<SaleItemDTO> items;
	
	public SaleDTO() {
	}
	
	public SaleDTO(Long id, Long custumerId, LocalDate saleDate, float totalValue, List<SaleItemDTO> items) {
		this.id = id;
		this.custumerId = custumerId;
		this.saleDate = saleDate;
		this.totalValue = totalValue;
		this.items = items;
	}

	public SaleDTO(Sale entity) {
	    this.id = entity.getId();
	    this.custumerId = entity.getCustomer().getId();
	    this.saleDate = entity.getSaleDate();
	    this.totalValue = entity.getTotalValue();
	    this.items = entity.getItems()
	            .stream()
	            .map(SaleItemDTO::new)
	            .toList();
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

	public Long getCustomerId() {
		return custumerId;
	}

	public void setCustomerId(Long custumerId) {
		this.custumerId = custumerId;
	}

	public List<SaleItemDTO> getItems() {
		return items;
	}

	public void setItems(List<SaleItemDTO> items) {
		this.items = items;
	}
}
