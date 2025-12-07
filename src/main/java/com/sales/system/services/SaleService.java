package com.sales.system.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.system.dto.SaleDTO;
import com.sales.system.dto.SaleItemDTO;
import com.sales.system.entities.Customer;
import com.sales.system.entities.Product;
import com.sales.system.entities.Sale;
import com.sales.system.entities.SaleItem;
import com.sales.system.exceptions.InsufficientStockException;
import com.sales.system.exceptions.NotFoundException;
import com.sales.system.repositories.CustomerRepository;
import com.sales.system.repositories.ProductRepository;
import com.sales.system.repositories.SaleItemRepository;
import com.sales.system.repositories.SaleRepository;

import jakarta.transaction.Transactional;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired 
	ProductRepository productRepository;
	
	@Autowired
	SaleItemRepository itemSaleRepository;
	
	@Transactional
	public Sale registerSale (SaleDTO dto) {
		Sale sale = new Sale();
		Customer customer = customerRepository.findById(dto.getCustomerId())
				.orElseThrow(() -> new NotFoundException("Customer with Id: " + dto.getCustomerId() + " not found."));
		
		sale.setSaleDate(LocalDate.now());
		sale.setCustomer(customer);
		
		float totalPrice = 0;
		List<SaleItem> items = new ArrayList<>();
		
		for (SaleItemDTO item : dto.getItems()) {
			Product product = productRepository.findById(item.getProductId())
					.orElseThrow(() -> new NotFoundException("Product with id: " + item.getProductId() + " not found."));
			
			Product productId = new Product();
			
			productId.setId(item.getProductId());
			
			float unitPrice = product.getPrice();
			int amount = item.getAmount();

			if (amount > product.getStockQuantity()) {
				throw new InsufficientStockException("Insufficient quantity in stock");
			}
			product.setStockQuantity(product.getStockQuantity() - amount);
			
			product = productRepository.save(product);
			
			totalPrice += unitPrice * amount;
			
			SaleItem saleItem = new SaleItem();
			
			saleItem.setAmount(amount);
			saleItem.setUnitPrice(unitPrice);
			saleItem.setProduct(productId);
			saleItem.setSale(sale);
			
			items.add(saleItem);
		}
		
		sale.setItems(items);
		sale.setTotalValue(totalPrice);
		
		sale = saleRepository.save(sale);
		
		return sale;
	}
	
	public List<Sale> findAllSales() {
		return saleRepository.findAll();
	}
	
	public Sale findById(Long id) {
		Sale sale = saleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Sale with Id: " + id + " not found."));
		
		return sale;
	}
	
}
