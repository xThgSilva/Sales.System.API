package com.sales.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.system.dto.CustomerDTO;
import com.sales.system.entities.Customer;
import com.sales.system.services.CustomerService;

@RestController
@RequestMapping(value = "/costumer")
public class CustomerController {

    @Autowired
    CustomerService costumerService;
    
    @PostMapping(value = "/register")
    public ResponseEntity<Customer> registerCostumer(@RequestBody CustomerDTO dto) {
        return costumerService.registerCostumer(dto);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<Customer>> findAll() {
        return costumerService.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        return costumerService.findById(id);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        costumerService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return costumerService.update(id, dto);
    }
}