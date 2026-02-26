package com.service;

import java.util.List;

import com.model.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);

   public Category getCategoryById(Long id);

   public List<Category> getAllCategories();

   public Category updateCategory(Long id, Category category);

    public void deleteCategory(Long id);
    
    public List<Category> getCategoryByType(String type);


}
