package com.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long budgetId;
    
    private int month;
    
    private int year;
    
    private Double limitAmount;
    
    @ManyToOne
    @JoinColumn(name="user_id")
  //  @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
   // @JsonBackReference
    private Category category;


	public Budget() {
		super();
	}

	public Budget(Long budgetId, int month, int year, Double limitAmount, User user, Category category) {
		super();
		this.budgetId = budgetId;
		this.month = month;
		this.year = year;
		this.limitAmount = limitAmount;
		this.user = user;
		this.category = category;
	}

	public Long getBudgetId() {
		return budgetId;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public Double getLimitAmount() {
		return limitAmount;
	}

	public User getUser() {
		return user;
	}

	public Category getCategory() {
		return category;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setLimitAmount(Double limitAmount) {
		this.limitAmount = limitAmount;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
	
    
    
    
}
