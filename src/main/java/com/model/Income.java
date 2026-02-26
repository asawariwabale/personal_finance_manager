package com.model;




import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Income {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private Long incomeId;
 
	private Double amount;
	
    private  LocalDate date;
    
    private String source;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    
    private User user;

	public Income() {
		super();
	}

	public Income(Long incomeId, Double amount, LocalDate date, String source, User user) {
		super();
		this.incomeId = incomeId;
		this.amount = amount;
		this.date = date;
		this.source = source;
		this.user = user;
	}

	public Long getIncomeId() {
		return incomeId;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getSource() {
		return source;
	}

	public User getUser() {
		return user;
	}

	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
