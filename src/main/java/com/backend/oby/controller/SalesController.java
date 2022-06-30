package com.backend.oby.controller;

import java.util.List;

import com.backend.oby.services.SalesService;
import com.backend.oby.entity.Sales;
import com.backend.oby.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    
    @Autowired
    private SalesService SalesService;

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        return new ResponseEntity<>(this.SalesService.getAllSales(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody Sales sales) {
        this.SalesService.createSale(sales);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable (value = "id") long salesId) {
        return new ResponseEntity<>(this.SalesService.getSalesById(salesId), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Sales> deleteUser(@PathVariable ("id") long salesId){
        this.SalesService.deleteUser(salesId);
        return new ResponseEntity<>(HttpStatus.OK);
	}
}
