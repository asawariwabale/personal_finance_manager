package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Expenses;
import com.service.ExpensesService;


@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "http://localhost:3000")

public class ExepenseController {
	
	
	 @Autowired
	    private ExpensesService expensesService;

	    @PostMapping("/add")
	    public ResponseEntity<Expenses> addExpense(@RequestBody Expenses expense) {
	        return ResponseEntity.ok(expensesService.addExpense(expense));
	    }

	    @GetMapping("/all")
	    public List<Expenses> getAllExpenses() {
	        return expensesService.getAllExpenses();
	    }

	    @GetMapping("/{id}")
	    public Expenses getExpenseById(@PathVariable Long id) {
	        return expensesService.getExpenseById(id);
	    }

	    @GetMapping("/user/{userId}")
	    public List<Expenses> getByUser(@PathVariable Long userId) {
	        return expensesService.getExpensesByUserId(userId);
	    }

	    @GetMapping("/category/{categoryId}")
	    public List<Expenses> getByCategory(@PathVariable Long categoryId) {
	        return expensesService.getExpensesByCategoryId(categoryId);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Expenses> updateExpense( @PathVariable Long id,@RequestBody Expenses expense) {

	        return ResponseEntity.ok(expensesService.updateExpense(id, expense));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
	    	expensesService.deleteExpense(id);
	        return ResponseEntity.ok("Expense deleted successfully");
	    }
	    
	    @GetMapping("/getExpenseByAmount/{amount}")
	    public ResponseEntity<List<Expenses>> getExpenseByAmount(@PathVariable Double amount) {
	        List<Expenses> list = expensesService.getExpenseByAmount(amount);
	        return ResponseEntity.status(HttpStatus.OK)
	                             .header("get", "get records")
	                             .body(list);
	    }
	    
	    @GetMapping("/exists/{id}")
	    public boolean exists(@PathVariable Long id) {
	        return expensesService.isExpenseExistsById(id);
	    }
	}

	    
	    

	


/*➤ Add Expense
 * POST http://localhost:8080/expenses/add
 * {
  "amount": 500,
  "date": "2026-02-14",
  "description": "Pizza",
  "user": {
    "id": 1
  },
  "category": {
    "categoryId": 1
  }
}
 * 
 * ➤ Get All
 * 
 * GET http://localhost:8080/expenses/all
 * 
 * 
 * ➤ Get By Id
GET http://localhost:8080/expenses/1


 * ➤ Get By User
GET http://localhost:8080/expenses/user/1

➤ Get By Category
GET http://localhost:8080/expenses/category/1

➤ Update
PUT http://localhost:8080/expenses/update/1


Body:

{
  "amount": 700,
  "date": "2026-02-15",
  "description": "Burger"
}

➤ Delete
DELETE http://localhost:8080/expenses/delete/1


>>>exits
http://localhost:8086/expenses/exists/1

>>>
http://localhost:8086/expenses/getExpenseByAmount/450000
 * 
 * */

