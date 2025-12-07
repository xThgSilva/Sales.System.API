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

import com.sales.system.dto.CostumerDTO;
import com.sales.system.entities.Costumer;
import com.sales.system.services.CostumerService;

@RestController
@RequestMapping(value = "/costumer")
public class CostumerController {

    @Autowired
    CostumerService costumerService;
    
    @PostMapping(value = "/register")
    public ResponseEntity<Costumer> registerCostumer(@RequestBody CostumerDTO dto) {
        return costumerService.registerCostumer(dto);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<Costumer>> findAll() {
        return costumerService.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Costumer> findById(@PathVariable Long id) {
        return costumerService.findById(id);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        costumerService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Costumer> update(@PathVariable Long id, @RequestBody CostumerDTO dto) {
        return costumerService.update(id, dto);
    }
}