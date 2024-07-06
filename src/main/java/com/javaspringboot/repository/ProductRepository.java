package com.javaspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaspringboot.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	// all are same
	// List<ProductEntity> findByCategoryName(String name);
	// List<ProductEntity> findProductByCategoryName(String name);
	List<ProductEntity> findProductEntityByCategoryName(String name); // added entity name

	List<ProductEntity> findProductEntityByCategoryId(Long id);

	// spring data JPA DSL
	List<ProductEntity> findProductByBarcode(String barcode);

	// jpql query
	@Query("SELECT p FROM ProductEntity p WHERE p.barcode = :barcode")
	List<ProductEntity> fetchProductsUsingJPQL(String barcode);
	
	// sql query
	@Query(value = "SELECT * FROM product p WHERE p.barcode = :barcode", nativeQuery = true)
	List<ProductEntity> fetchProductsUsingNative(String barcode);
}
