package com.sales.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sales.system.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository <Sale, Long>{

}
