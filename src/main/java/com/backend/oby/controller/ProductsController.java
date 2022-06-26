package com.backend.oby.controller;

import java.util.List;

import com.backend.oby.entity.Products;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.repository.ProductsRepository;
import com.backend.oby.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        return new ResponseEntity<>(this.productsService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable (value = "id") long productsId) {
		return new ResponseEntity<>(this.productsService.getProductsById(productsId), HttpStatus.OK);
	}

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Products products) {
		this.productsService.createProduct(products);
		return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
	public ResponseEntity<Void> updateProducts(@RequestBody Products products) {
		this.productsService.updateProducts(products);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Products> deleteUser(@PathVariable ("id") long productsId){
		this.productsService.deleteUser(productsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}