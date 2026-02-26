package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryRepository;
import com.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
    private CategoryRepository categoryRepo;

	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryById(Long id) {
		 return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
	}

	@Override
	public List<Category> getAllCategories() {
		 return categoryRepo.findAll();
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		Category existing = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setName(category.getName());
        existing.setType(category.getType());

        return categoryRepo.save(existing);
	}

	@Override
	public void deleteCategory(Long id) {
		Category existing = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));

        categoryRepo.delete(existing);
		
	}

	@Override
	public List<Category> getCategoryByType(String type) {
		
		return categoryRepo.findByTypeIgnoreCase(type);
	}

}
