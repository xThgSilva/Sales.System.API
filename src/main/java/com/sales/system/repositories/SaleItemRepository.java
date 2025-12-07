package com.sales.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.system.entities.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository <SaleItem, Long>{

}
