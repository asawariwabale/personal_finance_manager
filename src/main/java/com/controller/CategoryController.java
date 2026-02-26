package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Category;
import com.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")


public class CategoryController {
	
	 @Autowired
	private CategoryService categoryService;
	 
	 @PostMapping("/add")
	    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
	    }

	    
	    @GetMapping("/all")
	    public ResponseEntity<List<Category>> getAllCategories() {
	        return ResponseEntity.ok(categoryService.getAllCategories());
	    }

	   
	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	        return ResponseEntity.ok(categoryService.getCategoryById(id));
	    }

	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Category> updateCategory( @PathVariable Long id, @RequestBody Category category) {

	        return ResponseEntity.ok(categoryService.updateCategory(id, category));
	    }

	   
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {

	        categoryService.deleteCategory(id);
	        return ResponseEntity.ok("Category deleted successfully");
	    }
	
	    @GetMapping("/type/{type}")
	    public ResponseEntity<List<Category>> getCategoryByType(@PathVariable String type) {
	        return ResponseEntity.ok(categoryService.getCategoryByType(type));
	

}
}
/*
  http://localhost:8086/category/delete/2
  http://localhost:8086/category/add
  http://localhost:8086/category/all
  http://localhost:8086/category/1
  http://localhost:8086/category/delete/1
{
  "name": "Food",
  "type": "Expense"
}
  
 */
 