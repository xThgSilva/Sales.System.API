package com.sales.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sales.system.dto.CostumerDTO;
import com.sales.system.entities.Costumer;
import com.sales.system.exceptions.NotFoundException;
import com.sales.system.repositories.CostumerRepository;

@Service
public class CostumerService {

	@Autowired
	CostumerRepository costumerRepository;
	
	public ResponseEntity<Costumer> registerCostumer(CostumerDTO dto){
		Costumer costumer = new Costumer();
		
		costumer.setName(dto.getName());
		costumer.setEmail(dto.getEmail());
		costumer.setTelephone(dto.getTelephone());
		
		costumer = costumerRepository.save(costumer);
		
		return ResponseEntity.ok(costumer);
	}
	
	public ResponseEntity<List<Costumer>> findAll(){
		return ResponseEntity.ok(costumerRepository.findAll());
	}
	
	public ResponseEntity<Costumer> findById(Long id) {
		Costumer costumerExist = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Costumer with Id: " + id + " not found." ));
		
		return ResponseEntity.ok(costumerExist);
	}
	
	public void delete(Long id){
		Costumer costumer = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Costumer with Id: " + id + "not found." ));
		
		costumerRepository.deleteById(id);
	}
	
	public ResponseEntity<Costumer> update(Long id, CostumerDTO update) {
		Costumer costumer = costumerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Costumer with Id: " + id + "not found." ));
		
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
