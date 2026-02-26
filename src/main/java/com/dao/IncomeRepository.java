package com.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
	
	List<Income> findByUser_UserId(Long userId);

	//List<Income> findByUser_UserId(Long userId);
	
	 @Query("select i from Income i where i.amount > 50000")
		List<Income> findIncomeByAmount();
	 
	 @Query("select case  when count (i) > 0 then true else false end from Income i where i.incomeId = ?1")
	    Boolean isIncomeExistsById(Long id);

	 @Query("SELECT COALESCE(SUM(i.amount),0) FROM Income i WHERE i.user.id = :userId")
	 Double getTotalIncomeByUser(@Param("userId") Long userId);


}
