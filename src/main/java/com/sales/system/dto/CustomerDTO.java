package com.sales.system.dto;

import com.sales.system.entities.Customer;

public class CustomerDTO {
	private Long id;
	private String name;
	private String email;
	private long telephone;
	
	public CustomerDTO() {
	}
	
	public CustomerDTO(Long id, String name, String email, long telephone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}
	
	public CustomerDTO(Customer entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.telephone = entity.getTelephone();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
}
