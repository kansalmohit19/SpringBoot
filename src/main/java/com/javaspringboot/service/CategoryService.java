package com.javaspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.entities.CategoryEntity;
import com.javaspringboot.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public void createCategory(CategoryEntity category) {
		log.info("CategoryService ::: createCategory {}", category.toString());
		categoryRepository.save(category);
		log.info("CategoryService ::: category saved successfully");
	}

	public List<CategoryEntity> getAllCategories() {
		log.info("CategoryService ::: getAllCategories");
		return categoryRepository.findAll();
	}

	public CategoryEntity findCategoryById(Long categoryId) {
		log.info("CategoryService ::: findCategoryById {}", categoryId);
		return categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("No category found"));
	}

	public void updateCategoryById(Long categoryId, CategoryEntity inputCategory) {
		log.info("CategoryService ::: updateCategoryById {} {}", categoryId, inputCategory.toString());
		CategoryEntity dbCategory = findCategoryById(categoryId);
		if (dbCategory != null) {
			dbCategory.setName(inputCategory.getName());
			categoryRepository.save(dbCategory);
			log.info("CategoryService ::: category updated successfully");
		}
	}

	public void deleteCategoryById(Long categoryId) {
		log.info("CategoryService ::: deleteCategoryById {}}", categoryId);
		categoryRepository.deleteById(categoryId);
		log.info("CategoryService ::: category deleted successfully");
	}

}
