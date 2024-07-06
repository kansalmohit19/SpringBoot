package com.javaspringboot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.entities.ProductEntity;
import com.javaspringboot.exception.ResourceNotFoundException;
import com.javaspringboot.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void createProduct(ProductEntity product) {
		log.info("ProductService ::: createProduct {}", product.toString());
		product.setIsStock(true);
		product.setBarcode(UUID.randomUUID().toString());
		productRepository.save(product);
		log.info("ProductService ::: product saved successfully");
	}

	public List<ProductEntity> getAllProducts() {
		log.info("ProductService ::: getAllProducts");
		return productRepository.findAll();
	}

	public ProductEntity findProductById(Long productId) {
		log.info("ProductService ::: findProductById");
		return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("No product found"));
	}

	public void updateProductById(Long productId, ProductEntity inputProduct) {
		log.info("ProductService ::: updateProductById {} {}", productId, inputProduct.toString());
		ProductEntity dbProduct = findProductById(productId);
		if (dbProduct != null) {
			dbProduct.setName(inputProduct.getName());
			dbProduct.setPrice(inputProduct.getPrice());
			dbProduct.setQuantity(inputProduct.getQuantity());
			dbProduct.setDescription(inputProduct.getDescription());
			productRepository.save(dbProduct);
			log.info("ProductService ::: product updated successfully");
		}
	}

	public void deleteProductById(Long productId) {
		log.info("ProductService ::: deleteProductById {}", productId);
		ProductEntity dbProduct = findProductById(productId);
		productRepository.delete(dbProduct);
		log.info("ProductService ::: product deleted successfully");
	}
	
	public List<ProductEntity> findProductByCategoryName(String categoryName) {
		log.info("ProductService ::: findProductByCategoryName");
		return productRepository.findProductEntityByCategoryName(categoryName);
	}

	public List<ProductEntity> findProductByBarcode(String barcode) {
		log.info("ProductService ::: findProductByBarcode");
		return productRepository.fetchProductsUsingJPQL(barcode);
	}
	
	public List<ProductEntity> findProductByBarcode2(String barcode) {
		log.info("ProductService ::: findProductByBarcode2");
		return productRepository.fetchProductsUsingNative(barcode);
	}

}
