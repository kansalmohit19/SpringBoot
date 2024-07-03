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

import com.javaspringboot.entities.CategoryEntity;
import com.javaspringboot.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public void createCategory(@RequestBody CategoryEntity category) {
		log.info("CategoryController ::: createCategory {}", category.toString());
		categoryService.createCategory(category);
	}
	
	@GetMapping
	public List<CategoryEntity> getAllCategories() {
		log.info("CategoryController ::: getAllCategories");
		return categoryService.getAllCategories();
	}
	
	@GetMapping("{categoryId}")
	public CategoryEntity findCategoryById(@PathVariable Long categoryId) {
		log.info("CategoryController ::: findCategoryById {}", categoryId);
		return categoryService.findCategoryById(categoryId);
	}
	
	@PutMapping("{categoryId}")
	public void updateCategoryById(@PathVariable Long categoryId, @RequestBody CategoryEntity category) {
		log.info("CategoryController ::: updateCategoryById {} {}", categoryId, category.toString());
		categoryService.updateCategoryById(categoryId, category);
	}
	
	
	@DeleteMapping("{categoryId}")
	public void deleteCategoryById(@PathVariable Long categoryId) {
		log.info("CategoryController ::: deleteCategoryById {}", categoryId);
		categoryService.deleteCategoryById(categoryId);
	}

}
