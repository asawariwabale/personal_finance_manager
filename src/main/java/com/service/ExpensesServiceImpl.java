package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.CategoryRepository;
import com.dao.ExpensesRepository;
import com.dao.UserRepository;
import com.model.Category;
import com.model.Expenses;
import com.model.User;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ExpensesServiceImpl implements ExpensesService {
	
	@Autowired
    private ExpensesRepository expensesRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository categoryRepo;
   
    

	@Override
	public Expenses addExpense(Expenses expense) {
		 Long userId = expense.getUser().getUserId();User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		   
		    Long categoryId = expense.getCategory().getCategoryId();Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

		   
		    expense.setUser(user);
		    expense.setCategory(category);

		    return expensesRepo.save(expense);
        
	}

	@Override
	public Expenses getExpenseById(Long id) {
		 
		return expensesRepo.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
	}

	@Override
	public List<Expenses> getAllExpenses() {
		
		return expensesRepo.findAll();
	}

	@Override
	public List<Expenses> getExpensesByUserId(Long userId) {
		
		return expensesRepo.findByUserUserId(userId);
	}

	@Override
	public List<Expenses> getExpensesByCategoryId(Long categoryId) {
		
		return expensesRepo.findByCategoryCategoryId(categoryId);
	}

	@Override
	public Expenses updateExpense(Long id, Expenses expense) {
		Expenses existing = expensesRepo.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));

        existing.setAmount(expense.getAmount());
        existing.setDate(expense.getDate());
        existing.setDescription(expense.getDescription());

        return expensesRepo.save(existing);
	}

	@Override
	public void deleteExpense(Long id) {
		if (!expensesRepo.existsById(id)) {
	        throw new RuntimeException("Expense not found with id: " + id);
	    }
	    expensesRepo.deleteById(id);
		
	}

	@Override
	public List<Expenses> getExpenseByAmount(Double amount) {
		
		return expensesRepo.findExpenseByAmount(amount);
	}

	@Override
	public Boolean isExpenseExistsById(Long id) {
		return expensesRepo.isExpenseExistsById(id);
	}

	

}

	
	
	


