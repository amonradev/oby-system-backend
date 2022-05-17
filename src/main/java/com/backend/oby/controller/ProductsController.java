package com.backend.oby.controller;

import java.util.List;

import com.backend.oby.entity.Products;
import com.backend.oby.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping
    public List<Products> getAllProducts() {
        return this.productsRepository.findAll();
    }
}
