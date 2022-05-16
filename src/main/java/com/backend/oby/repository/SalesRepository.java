package com.backend.oby.repository;

import com.backend.oby.entity.Sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    
}
