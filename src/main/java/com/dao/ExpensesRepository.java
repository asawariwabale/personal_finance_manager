package com.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long>{
	
	List<Expenses> findByUserUserId(Long userId);


	    List<Expenses> findByCategoryCategoryId(Long categoryId);

	    @Query("SELECT e FROM Expenses e WHERE e.amount >:amount")
	    List<Expenses> findExpenseByAmount(@Param("amount") Double amount);
	    
	    
	    @Query("select case when count(e) > 0 then true else false end from Expenses e where e.id = ?1")
	    Boolean isExpenseExistsById(Long id);
	    
	    @Query("SELECT COALESCE(SUM(e.amount),0) FROM Expenses e WHERE e.user.id = :userId")
	    Double getTotalExpenseByUser(@Param("userId") Long userId);


	    
}
