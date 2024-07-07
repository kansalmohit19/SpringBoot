package com.javaspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.entities.ProductEntity;
import com.javaspringboot.responses.ProductBoResponse;
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

	@GetMapping("/category/{name}")
	public List<ProductEntity> findProductByCategoryName(@PathVariable String name) {
		log.info("ProductController ::: findProductByCategoryName {}", name);
		return productService.findProductByCategoryName(name);
	}

	@GetMapping("/barcode/{barcode}")
	public List<ProductEntity> findProductByBarcode(@PathVariable String barcode) {
		log.info("ProductController ::: findProductByBarcode {}", barcode);
		return productService.findProductByBarcode(barcode);
	}

	@GetMapping("/barcode2/{barcode}")
	public List<ProductEntity> findProductByBarcode2(@PathVariable String barcode) {
		log.info("ProductController ::: findProductByBarcode {}", barcode);
		return productService.findProductByBarcode2(barcode);
	}

	@GetMapping("/pagination")
	public ProductBoResponse findProductByPagination(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "price") String sortBy, @RequestParam(defaultValue = "ASC") String sortOrder) {
		log.info("ProductController ::: findProductByPagination pageNo: {} pageSize: {} sortBy: {} sortOrder: {}",
				pageNo, pageSize, sortBy, sortOrder);

		if (sortOrder.equals("ASC")) {
			return productService.findProductByPagination(PageRequest.of(pageNo, pageSize, Direction.ASC, sortBy));
		} else {
			return productService.findProductByPagination(PageRequest.of(pageNo, pageSize, Direction.DESC, sortBy));
		}
	}

}
