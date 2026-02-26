package com.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Long categoryId;

    private String name;
    
    private String  type;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JsonIgnore
   // @JsonManagedReference
    private List<Expenses> expenses;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
   // @JsonManagedReference(value = "category-budget")
    private List<Budget> budgets;

	public Category() {
		super();
	}

	public Category(Long categoryId, String name, String type, List<Expenses> expenses, List<Budget> budgets) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.type = type;
		this.expenses = expenses;
		this.budgets = budgets;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public List<Expenses> getExpenses() {
		return expenses;
	}

	public List<Budget> getBudgets() {
		return budgets;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}

	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}

	
    
	

}
