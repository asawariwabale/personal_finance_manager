package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IncomeRepository;
import com.dao.UserRepository;

import com.model.Income;
import com.model.User;

@Service
public class IncomeServiceImpl implements IncomeService {
	
	@Autowired
    private IncomeRepository incomeRepo;

    @Autowired
    private UserRepository userRepo;

	@Override
	public Income addIncome(Income income) {
		
		Long userId = income.getUser().getUserId();User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        income.setUser(user);

        return incomeRepo.save(income);
	}

	@Override
	public Income getIncomeById(Long id) {
		
		 return incomeRepo.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
	}

	@Override
	public List<Income> getAllIncomes() {
		
		return incomeRepo.findAll();
	}

	@Override
	public List<Income> getIncomesByUserId(Long userId) {
		 
		return incomeRepo.findByUser_UserId(userId);
	}

	@Override
	public Income updateIncome(Long id, Income income) {
		
		Income existing = getIncomeById(id);

        existing.setAmount(income.getAmount());
        existing.setSource(income.getSource());
        existing.setDate(income.getDate());

        return incomeRepo.save(existing);
	}

	@Override
	public void deleteIncome(Long id) {
		
		Income income = getIncomeById(id);
        incomeRepo.delete(income);
		
	}

	
	@Override
	public Boolean checkIncomeExists(Long id) {
		return incomeRepo.isIncomeExistsById(id);
	}

	@Override
	public List<Income> getIncomeByAmount(Double amount, Long userId) {
		return getIncomeByAmount(amount, null);
	}

	

	

	
	
	

	


}
