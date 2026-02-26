package com.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
 private Long userId;
    
    private String username;
    private String email;
    private String password;

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    
    private List<Income> incomes;

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Expenses> expenses;

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore

    @JsonManagedReference(value = "user-budget")
    private List<Budget> budgets;


	public User() {
		super();
	}


	public User(Long userId, String username, String email, String password, List<Income> incomes,
			List<Expenses> expenses, List<Budget> budgets) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.incomes = incomes;
		this.expenses = expenses;
		this.budgets = budgets;
	}


	public Long getUserId() {
		return userId;
	}


	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public List<Income> getIncomes() {
		return incomes;
	}


	public List<Expenses> getExpenses() {
		return expenses;
	}


	public List<Budget> getBudgets() {
		return budgets;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}


	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}


	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}


	


	

	

}
/*
http://localhost:8086/income/add


{
"amount": 450000,
"source": "shop",
"date": "2026-02-14",
"user": {
  "userId": 1
}
}


http://localhost:8080/income/get/1
http://localhost:8080/income/all
http://localhost:8080/income/user/1
http://localhost:8080/income/update/1
http://localhost:8080/income/delete/1

*/