package com.javaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
