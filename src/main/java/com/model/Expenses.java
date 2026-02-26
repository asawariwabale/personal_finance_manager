package com.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expenses {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	private Long expenseId;
	
	private Double amount;
	
	private LocalDate date;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	
	private User user;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	//@JsonIgnore
	//@JsonBackReference
	private Category category;

	public Expenses() {
		super();
	}

	public Expenses(Long expenseId, Double amount, LocalDate date, String description, User user, Category category) {
		super();
		this.expenseId = expenseId;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.user = user;
		this.category = category;
	}

	public Long getExpenseId() {
		return expenseId;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public User getUser() {
		return user;
	}

	public Category getCategory() {
		return category;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	

}
