package com.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Budget;



public interface BudgetRepository extends JpaRepository<Budget, Long> {

	List<Budget> findByUserUserId(Long userId);
	
	@Query("SELECT b FROM Budget b WHERE b.limitAmount > :amount")
	List<Budget> findByLimitAmount(Double amount);
 
	boolean existsById(Long id); 
	
	
	@Query("SELECT b FROM Budget b WHERE b.user.userId = :userId AND b.category.categoryId = :categoryId AND b.month = :month AND b.year = :year")
    List<Budget> findBudgetByUserCategoryMonthYear(@Param("userId") Long userId,
                                                   @Param("categoryId") Long categoryId,
                                                   @Param("month") int month,
                                                   @Param("year") int year);
	
	@Query("SELECT SUM(e.amount) FROM Expenses e WHERE e.user.userId = :userId AND e.category.categoryId = :categoryId AND MONTH(e.date) = :month AND YEAR(e.date) = :year")
	Double totalExpensesByUserCategoryMonthYear(
	        @Param("userId") Long userId,
	        @Param("categoryId") Long categoryId,
	        @Param("month") int month,
	        @Param("year") int year
	);
}



	

    




