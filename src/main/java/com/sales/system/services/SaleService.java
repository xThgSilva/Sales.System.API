package com.sales.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.system.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;
	
}
