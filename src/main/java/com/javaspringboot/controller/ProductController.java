package com.javaspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.entities.ProductEntity;
import com.javaspringboot.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public void createProduct(@RequestBody ProductEntity product) {
		log.info("ProductController ::: createCategory {}", product.toString());
		productService.createProduct(product);
	}
	
	@GetMapping
	public List<ProductEntity> getAllProducts() {
		log.info("ProductController ::: getAllProducts");
		return productService.getAllProducts();
	}
	
	@GetMapping("{productId}")
	public ProductEntity findProductById(@PathVariable Long productId) {
		log.info("ProductController ::: findProductById {}", productId);
		return productService.findProductById(productId);
	}
	
	@PutMapping("{productId}")
	public void updateProductById(@PathVariable Long productId, @RequestBody ProductEntity product) {
		log.info("ProductController ::: updateProductById {} {}", productId, product.toString());
		productService.updateProductById(productId, product);
	}
	
	
	@DeleteMapping("{productId}")
	public void deleteProductById(@PathVariable Long productId) {
		log.info("ProductController ::: deleteProductById {}", productId);
		productService.deleteProductById(productId);
	}
}
