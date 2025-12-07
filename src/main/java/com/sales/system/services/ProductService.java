package com.sales.system.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.system.dto.ProductDTO;
import com.sales.system.entities.Product;
import com.sales.system.exceptions.NotFoundException;
import com.sales.system.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product registerProduct(ProductDTO dto) {
		Product product = new Product();
		
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setStockQuantity(dto.getStockQuantity());
		
		product = productRepository.save(product);
		
		return product;
	}
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product with Id: " + id + " not found."));
		
		return product;
	}
	
	public void delete(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product with Id: " + id + " not found."));
		
		productRepository.deleteById(id);
	}
	
	public Product updateProduct(Long id, ProductDTO update) { 
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product with Id: " + id + " not found."));
		
		if (product != null && !product.getName().isBlank())
			product.setName(update.getName());
		
		if (product != null && !(product.getPrice() != 0)) 
			product.setPrice(update.getPrice());
		
		if (product != null && !(product.getStockQuantity() != 0))
			product.setStockQuantity(update.getStockQuantity());
		
		product = productRepository.save(product);
		
		return product;
	}
} 
