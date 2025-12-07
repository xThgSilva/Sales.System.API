package com.sales.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.system.dto.ProductDTO;
import com.sales.system.entities.Product;
import com.sales.system.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Product> registerProduct(@RequestBody ProductDTO dto) {
		return productService.registerProduct(dto);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Product>> findAllProducts() {
		return productService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(Long id) {
		return productService.findById(id);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Product> delete(Long id) {
		productService.delete(id);
        return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Product> update(Long id, ProductDTO update) {
		return productService.updateProduct(id, update);
	}
}
