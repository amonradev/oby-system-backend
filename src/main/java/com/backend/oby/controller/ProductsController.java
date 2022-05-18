package com.backend.oby.controller;

import java.util.List;

import com.backend.oby.entity.Products;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping
    public List<Products> getAllProducts() {
        return this.productsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Products getProductsById(@PathVariable (value = "id") long productsId) {
        return this.productsRepository.findById(productsId).orElseThrow(() -> new ResourceNotFoundException("Products not found with id: "+ productsId));
    }

    @PostMapping
    public Products createProduct(@RequestBody Products products) {
        return this.productsRepository.save(products);
    }
    
    @PutMapping("/{id}")
	public Products updateProducts(@RequestBody Products products, @PathVariable ("id") long productsId) {
		 Products existingProduct = this.productsRepository.findById(productsId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + productsId));
		 existingProduct.setName(existingProduct.getName());
		 existingProduct.setPrice(existingProduct.getPrice());
		 existingProduct.setQuantity(existingProduct.getQuantity());
		 return this.productsRepository.save(existingProduct);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Products> deleteUser(@PathVariable ("id") long productsId){
		 Products existingProducts = this.productsRepository.findById(productsId)
					.orElseThrow(() -> new ResourceNotFoundException("Clients not found with id: " + productsId));
		 this.productsRepository.delete(existingProducts);
		 return ResponseEntity.ok().build();
	}
}