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

import com.model.Income;
import com.service.IncomeService;

@RestController
@RequestMapping("/income")
@CrossOrigin(origins = "http://localhost:3000")
public class IncomeController {
	
	@Autowired
    private IncomeService incomeService;

    
    @PostMapping("/add")
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        return ResponseEntity.ok(incomeService.addIncome(income));
    }

    
    @GetMapping("/get/{id}")
    public ResponseEntity<Income> getIncome(@PathVariable Long id) {
        return ResponseEntity.ok(incomeService.getIncomeById(id));
    }

    // Get all incomes
    @GetMapping("/all")
    public ResponseEntity<List<Income>> getAll() {
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }

    // Get incomes by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Income>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(incomeService.getIncomesByUserId(userId));
    }

    // Update income
    @PutMapping("/update/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        return ResponseEntity.ok(incomeService.updateIncome(id, income));
    }

    // Delete income
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.ok("Income deleted successfully");
    }
	
   @GetMapping("/getIncomeByAmount/{Amount}")
    public ResponseEntity<List<Income>> getIncomeByAmount(@PathVariable Double Amount) {
        List<Income> incomes = incomeService.getIncomeByAmount(Amount, null);
        return ResponseEntity.status(HttpStatus.OK)
                             .header("get", "records with amount greater than " + Amount)
                             .body(incomes);
        }
	
    @GetMapping("/checkIncomeExists/{id}")
    public ResponseEntity<Boolean> checkIncomeExists(@PathVariable Long id) {
        Boolean exists = incomeService.checkIncomeExists(id);
        return ResponseEntity.status(HttpStatus.OK)
                             .header("check", "check if income exists by id")
                             .body(exists);
    }

}





/*
✅ Add Income

POST

http://localhost:8080/income/add


Body (raw JSON):

{
  "amount": 50000,
  "source": "Salary",
  "date": "2026-02-14",
  "user": {
    "id": 1
  }
}

✅ Get Income By ID

GET

http://localhost:8086/income/get/1

✅ Get All Incomes

GET

http://localhost:8086/income/all

✅ Get Incomes By User

GET

http://localhost:8086/income/user/1

✅ Update Income

PUT

http://localhost:8086/income/update/1


Body:

{
  "amount": 60000,
  "source": "Business",
  "date": "2026-02-15"
}

✅ Delete Income

DELETE

http://localhost:8086/income/delete/1

>>>
http://localhost:8086/income/checkIncomeExists/3

>>>
http://localhost:8086/income/getIncomeByAmountUsingParam/60000
*/

