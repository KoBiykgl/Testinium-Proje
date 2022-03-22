package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoryService categoryService;

	
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}



	@GetMapping
	public List<Category> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping("/{categoryId}")
	public Category getById(@PathVariable Long categoryId){
		return categoryService.getCategoryById(categoryId);
	}
	
	@PostMapping
	public Category Create(@RequestBody Category newCategory) {
		return categoryService.createOneCategory(newCategory);
	}
	
	
}
