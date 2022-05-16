package com.backend.oby.controller;

import java.util.List;

import com.backend.oby.repository.SalesRepository;
import com.backend.oby.entity.Sales;
import com.backend.oby.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
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
    private SalesRepository SalesRepository;

    @GetMapping
    public List<Sales> getAllSales() {
        return this.SalesRepository.findAll();
    }

    @PostMapping
    public Sales createSale(@RequestBody Sales sales) {
        return this.SalesRepository.save(sales);
    }

    // @GetMapping("/{id}")
    // public getSalesById(@PathVariable (value = "id") long userId) {
        // return this.userRepository.findById(salesId)
    // }
}