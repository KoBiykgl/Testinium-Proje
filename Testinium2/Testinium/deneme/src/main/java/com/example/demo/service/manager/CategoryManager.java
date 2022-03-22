package com.example.demo.service.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryManager(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	@Override
	public Category getCategoryById(Long categoryId) {
		
		return categoryRepository.findById(categoryId).orElse(null);
	}
	@Override
	public Category createOneCategory(Category newCategory) {
		
		return categoryRepository.save(newCategory);
	}

}
