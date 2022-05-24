package com.backend.oby.services;

import java.util.List;

import com.backend.oby.entity.Products;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> getAllProducts() {
        return this.productsRepository.findAll();
    }

    public Products getProductsById(long productsId) {
        return this.productsRepository.findById(productsId)
        .orElseThrow(() -> new ResourceNotFoundException("Products not found with id: "+ productsId));
    }

    public Products createProduct(Products products) {
        return this.productsRepository.save(products);
    }
    
	public Products updateProducts(Products products) {
		 return this.productsRepository.save(products);
	}
	
	public void deleteUser(long productsId){
		 Products existingProducts = this.productsRepository.findById(productsId)
					.orElseThrow(() -> new ResourceNotFoundException("Clients not found with id: " + productsId));
		 this.productsRepository.delete(existingProducts);
	}
}
