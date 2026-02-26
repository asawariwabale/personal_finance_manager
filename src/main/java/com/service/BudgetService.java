package com.service;

import java.util.List;
import com.model.Budget;

public interface BudgetService {

    public Budget addBudget(Budget budget);

   public  Budget getBudgetById(Long id);

    public List<Budget> getAllBudgets();

    public List<Budget> getBudgetsByUser(Long userId);

   public Budget updateBudget(Long id, Budget budget);

    public void deleteBudget(Long id);

    public List<Budget> findByLimitAmount(Double amount);

    public Boolean isBudgetExistsById(Long id);

  public  List<Budget> getBudgetByUserCategoryAndMonthYear(Long userId, Long categoryId, int month, int year);

    public Double getTotalExpenses(Long userId, Long categoryId, int month, int year);
    
    
}