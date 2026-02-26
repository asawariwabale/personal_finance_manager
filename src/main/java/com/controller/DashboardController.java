package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ExpensesRepository;
import com.dao.IncomeRepository;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {
	@Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    @GetMapping("/{userId}")
    public Map<String, Double> getDashboardData(@PathVariable Long userId) {

        Double totalIncome = incomeRepository.getTotalIncomeByUser(userId);
        Double totalExpense = expensesRepository.getTotalExpenseByUser(userId);

        if (totalIncome == null) totalIncome = 0.0;
        if (totalExpense == null) totalExpense = 0.0;

        Double balance = totalIncome - totalExpense;

        Map<String, Double> response = new HashMap<>();
        response.put("totalIncome", totalIncome);
        response.put("totalExpense", totalExpense);
        response.put("balance", balance);

        return response;
    }

}
