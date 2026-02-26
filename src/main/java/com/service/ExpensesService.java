package com.service;

import java.util.List;

import com.model.Expenses;

public interface ExpensesService {
	
	public Expenses addExpense(Expenses expense);

	public Expenses getExpenseById(Long id);

	public   List<Expenses> getAllExpenses();

	public    List<Expenses> getExpensesByUserId(Long userId);

	 public  List<Expenses> getExpensesByCategoryId(Long categoryId);

	 public  Expenses updateExpense(Long id, Expenses expense);

	  public  void deleteExpense(Long id);
	  
	  public List<Expenses> getExpenseByAmount(Double amount);
	  
	  public Boolean isExpenseExistsById(Long id);

	 
}
