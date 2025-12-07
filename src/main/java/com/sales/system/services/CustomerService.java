package com.sales.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sales.system.dto.CustomerDTO;
import com.sales.system.entities.Customer;
import com.sales.system.exceptions.NotFoundException;
import com.sales.system.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository costumerRepository;
	
	public ResponseEntity<Customer> registerCostumer(CustomerDTO dto){
		Customer costumer = new Customer();
		
		costumer.setName(dto.getName());
		costumer.setEmail(dto.getEmail());
		costumer.setTelephone(dto.getTelephone());
		
		costumer = costumerRepository.save(costumer);
		
		return ResponseEntity.ok(costumer);
	}
	
	public ResponseEntity<List<Customer>> findAll(){
		return ResponseEntity.ok(costumerRepository.findAll());
	}
	
	public ResponseEntity<Customer> findById(Long id) {
		Customer costumerExist = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Costumer with Id: " + id + " not found." ));
		
		return ResponseEntity.ok(costumerExist);
	}
	
	public void delete(Long id){
		Customer costumer = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Costumer with Id: " + id + " not found." ));
		
		costumerRepository.deleteById(id);
	}
	
	public ResponseEntity<Customer> update(Long id, CustomerDTO update) {
		Customer costumer = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Costumer with Id: " + id + " not found." ));
		
		if (update.getName() != null && !update.getName().isBlank()) {
			costumer.setName(update.getName());
		}
		
		if (update.getEmail() != null && !update.getEmail().isBlank()) {
			costumer.setEmail(update.getEmail());
		}
		
		if (update.getTelephone() != 0) {
			costumer.setTelephone(update.getTelephone());
		}
		
		costumer = costumerRepository.save(costumer);
		
		return ResponseEntity.ok(costumer);
	}
}
