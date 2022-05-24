package com.backend.oby.services;

import java.util.List;

import com.backend.oby.entity.Sales;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.repository.SalesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {
    
    @Autowired
    private SalesRepository SalesRepository;

    public List<Sales> getAllSales() {
        return this.SalesRepository.findAll();
    }

    public Sales createSale(Sales sales) {
        return this.SalesRepository.save(sales);
    }

    public Sales getSalesById(long salesId) {
        return this.SalesRepository.findById(salesId)
        .orElseThrow(() -> new ResourceNotFoundException("Sale not found with id: " + salesId));
    }
	
	public void deleteUser(long salesId){
		 Sales existingSales = this.SalesRepository.findById(salesId)
					.orElseThrow(() -> new ResourceNotFoundException("Clients not found with id: " + salesId));
		 this.SalesRepository.delete(existingSales);
	}
}
