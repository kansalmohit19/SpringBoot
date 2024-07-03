package com.javaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
