package com.service;

import java.util.List;



import com.model.Income;

public interface IncomeService {

	 public Income addIncome(Income income);
	 
	 public Income getIncomeById(Long id);
	 
	public List<Income> getAllIncomes();
	 
	 public List<Income> getIncomesByUserId(Long userId);
	 
	public Income updateIncome(Long id, Income income);
	 
	 public void deleteIncome(Long id);
	 
	 public Boolean checkIncomeExists(Long id);
	 
	 public List<Income> getIncomeByAmount(Double amount, Long userId);

	
	 
	 
	
}

