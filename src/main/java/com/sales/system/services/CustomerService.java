package com.sales.system.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.system.dto.CustomerDTO;
import com.sales.system.entities.Customer;
import com.sales.system.exceptions.NotFoundException;
import com.sales.system.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository costumerRepository;
	
	public Customer registerCostumer(CustomerDTO dto){
		Customer costumer = new Customer();
		
		costumer.setName(dto.getName());
		costumer.setEmail(dto.getEmail());
		costumer.setTelephone(dto.getTelephone());
		
		costumer = costumerRepository.save(costumer);
		
		return costumer;
	}
	
	public List<Customer> findAllCustomers(){
		return (costumerRepository.findAll());
	}
	
	public Customer findById(Long id) {
		Customer costumerExist = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Customer with Id: " + id + " not found." ));
		
		return costumerExist;
	}
	
	public void delete(Long id){
		Customer costumer = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Customer with Id: " + id + " not found." ));
		
		costumerRepository.deleteById(id);
	}
	
	public Customer update(Long id, CustomerDTO update) {
		Customer costumer = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Customer with Id: " + id + " not found." ));
		
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
		
		return costumer;
	}
}
