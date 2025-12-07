package com.sales.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.system.entities.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository <Costumer, Long>{

}
