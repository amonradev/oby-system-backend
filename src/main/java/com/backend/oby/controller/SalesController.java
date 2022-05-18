package com.backend.oby.controller;

import java.util.List;

import com.backend.oby.repository.SalesRepository;
import com.backend.oby.entity.Sales;
import com.backend.oby.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    
    @Autowired
    private SalesRepository SalesRepository;

    @GetMapping
    public List<Sales> getAllSales() {
        return this.SalesRepository.findAll();
    }

    @PostMapping
    public Sales createSale(@RequestBody Sales sales) {
        return this.SalesRepository.save(sales);
    }

    @GetMapping("/{id}")
    public Sales getSalesById(@PathVariable (value = "id") long salesId) {
        return this.SalesRepository.findById(salesId)
        .orElseThrow(() -> new ResourceNotFoundException("Sale not found with id: " + salesId));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Sales> deleteUser(@PathVariable ("id") long salesId){
		 Sales existingSales = this.SalesRepository.findById(salesId)
					.orElseThrow(() -> new ResourceNotFoundException("Clients not found with id: " + salesId));
		 this.SalesRepository.delete(existingSales);
		 return ResponseEntity.ok().build();
	}
}
