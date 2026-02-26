
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

    import com.model.Budget;
    import com.service.BudgetService;

    @RestController
    @RequestMapping("/budget")
    @CrossOrigin(origins = "http://localhost:3000")

    public class BudgetController{
    	

        @Autowired
        private BudgetService budgetService;
        
        
        @PostMapping("/add")
        public ResponseEntity<Budget> addBudget(@RequestBody Budget budget) {
            return ResponseEntity.ok(budgetService.addBudget(budget));
        }

        @GetMapping("/get/{id}")
        public ResponseEntity<Budget> getBudget(@PathVariable Long id) {
            return ResponseEntity.ok(budgetService.getBudgetById(id));
        }

        @GetMapping("/all")
        public ResponseEntity<List<Budget>> getAll() {
            return ResponseEntity.ok(budgetService.getAllBudgets());
        }

        @GetMapping("/user/{userId}")
        public ResponseEntity<List<Budget>> getByUser(@PathVariable Long userId) {
            return ResponseEntity.ok(budgetService.getBudgetsByUser(userId));
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Budget> updateBudget(@PathVariable Long id,
                                                   @RequestBody Budget budget) {
            return ResponseEntity.ok(budgetService.updateBudget(id, budget));
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteBudget(@PathVariable Long id) {
            budgetService.deleteBudget(id);
            return ResponseEntity.ok("Budget deleted successfully");
        }
        
        @GetMapping("/getBudgetByAmount/{amount}")
        public ResponseEntity<List<Budget>> getBudgetByAmount(@PathVariable Double amount) {

            List<Budget> list = budgetService.findByLimitAmount(amount);

            return ResponseEntity.status(HttpStatus.OK)
                                 .header("get", "get records greater than " + amount)
                                 .body(list);
        }
        
        @GetMapping("/exists/{id}")
        public Boolean isExists(@PathVariable Long id) {
            return budgetService.isBudgetExistsById(id);
        }
        
        @GetMapping("/user/{userId}/category/{categoryId}/month/{month}/year/{year}")
        public ResponseEntity<List<Budget>> getBudgetByUserCategoryMonthYear(
                @PathVariable Long userId,
                @PathVariable Long categoryId,
                @PathVariable int month,
                @PathVariable int year) {

            List<Budget> list = budgetService.getBudgetByUserCategoryAndMonthYear(userId, categoryId, month, year);

            if (list.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);
            }
            return ResponseEntity.ok(list);
        }

       
    }
    /*

    ➤ Add Budget
    POST http://localhost:8080/budget/add

    Body:
    {
      "month": 2,
      "year": 2026,
      "limitAmount": 20000,
      "user": {
        "userId": 1
      },
      "category": {
        "categoryId": 1
      }
    }

    ➤ Get By Id
    GET http://localhost:8080/budget/get/1

    ➤ Get All
    GET http://localhost:8080/budget/all

    ➤ Get By User
    GET http://localhost:8080/budget/user/1

    ➤ Update
    PUT http://localhost:8080/budget/update/1


    Body:

    {
      "month": 3,
      "year": 2026,
      "limitAmount": 25000
    }

    ➤ Delete
    DELETE http://localhost:8080/budget/delete/1

    >getexits
     http://localhost:8086/budget/exists/1
     
     >>>
     http://localhost:8086/budget/getBudgetByAmount/75000


    */

  
   

/*

➤ Add Budget
POST http://localhost:8080/budget/add

Body:
{
  "month": 2,
  "year": 2026,
  "limitAmount": 20000,
  "user": {
    "userId": 1
  },
  "category": {
    "categoryId": 1
  }
}

➤ Get By Id
GET http://localhost:8080/budget/get/1

➤ Get All
GET http://localhost:8080/budget/all

➤ Get By User
GET http://localhost:8080/budget/user/1

➤ Update
PUT http://localhost:8080/budget/update/1


Body:

{
  "month": 3,
  "year": 2026,
  "limitAmount": 25000
}

➤ Delete
DELETE http://localhost:8080/budget/delete/1

>getexits
 http://localhost:8086/budget/exists/1
 
 >>>
 http://localhost:8086/budget/getBudgetByAmount/75000


*/