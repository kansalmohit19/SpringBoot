package com.javaspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	
	List<ProductEntity> findProductByCategoryName(String name);
	
	
	
	List<ProductEntity> findProductByCategoryId(Long id);
}
