package com.sales.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.system.dto.SaleDTO;
import com.sales.system.entities.Sale;
import com.sales.system.services.SaleService;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

	@Autowired
	SaleService saleService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Sale> registerSale(@RequestBody SaleDTO dto) {
		return ResponseEntity.ok(saleService.registerSale(dto));
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Sale>> findAllSales() {
		return ResponseEntity.ok(saleService.findAllSales());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Sale> findById(@PathVariable Long id) {
		return ResponseEntity.ok(saleService.findById(id));
	}
}
