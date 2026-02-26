package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BudgetRepository;
import com.dao.CategoryRepository;
import com.dao.UserRepository;
import com.model.Budget;
import com.model.Category;
import com.model.User;

@Service
public class BudgetServiceImpl implements BudgetService  {
	
	@Autowired
    private BudgetRepository budgetRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository categoryRepo;

	@Override
	public Budget addBudget(Budget budget) {
		
		
		
		    if (budget.getUser() == null || budget.getUser().getUserId() == null) {
		        throw new RuntimeException("User id is required");
		    }

		    if (budget.getCategory() == null || budget.getCategory().getCategoryId() == null) {
		        throw new RuntimeException("Category id is required");
		    }

		    // 🔹 Get user and category objects from DB
		    User user = userRepo.findById(budget.getUser().getUserId())
		            .orElseThrow(() -> new RuntimeException("User not found"));

		    Category category = categoryRepo.findById(budget.getCategory().getCategoryId())
		            .orElseThrow(() -> new RuntimeException("Category not found"));

		    // 🔹 Step 1: check total assigned budgets for this user-category-month-year
		    List<Budget> existingBudgets = budgetRepo.findBudgetByUserCategoryMonthYear(
		            user.getUserId(),
		            category.getCategoryId(),
		            budget.getMonth(),
		            budget.getYear()
		    );

		    double totalAssigned = existingBudgets.stream()
		            .mapToDouble(Budget::getLimitAmount)
		            .sum();

		    // 🔹 Step 2: if new limit exceeds allowed budget
		    if (totalAssigned + budget.getLimitAmount() > budget.getLimitAmount()) {
		        throw new RuntimeException("Budget limit exceeded for this category!");
		    }

		    // 🔹 Step 3: set user and category
		    budget.setUser(user);
		    budget.setCategory(category);

		    return budgetRepo.save(budget);
		}
	

	@Override
	public Budget getBudgetById(Long id) {
		
		 return budgetRepo.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
	    }

	@Override
	public List<Budget> getAllBudgets() {
		
		return budgetRepo.findAll();
	}

	@Override
	public List<Budget> getBudgetsByUser(Long userId) {
	
		return budgetRepo.findByUserUserId(userId);
	}

	@Override
	public Budget updateBudget(Long id, Budget budget) {
		
		Budget existing = getBudgetById(id);

        existing.setMonth(budget.getMonth());
        existing.setYear(budget.getYear());
        existing.setLimitAmount(budget.getLimitAmount());

        return budgetRepo.save(existing);
	}

	@Override
	public void deleteBudget(Long id) {
		Budget budget = getBudgetById(id);
        budgetRepo.delete(budget);
		
	}

	@Override
	public List<Budget> findByLimitAmount(Double amount) {
		return budgetRepo.findByLimitAmount(amount);
	}

	@Override
	public Boolean isBudgetExistsById(Long id) {
		return budgetRepo.existsById(id);
	}

	@Override
	public List<Budget> getBudgetByUserCategoryAndMonthYear(Long userId, Long categoryId, int month, int year) {
		List<Budget> budgets = budgetRepo.findBudgetByUserCategoryMonthYear(userId, categoryId, month, year);
        return budgets;
	}

	@Override
	public Double getTotalExpenses(Long userId, Long categoryId, int month, int year) {
		Double total = budgetRepo.totalExpensesByUserCategoryMonthYear(userId, categoryId, month, year);
	    return total != null ? total : 0.0;
	}


       
}


	
	
	


