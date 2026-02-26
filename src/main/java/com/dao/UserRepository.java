package com.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	
	 User findByUsername(String  username);
	
	 Optional<User> findByEmail(String email);
	 
	 User findByPassword(String password);

	 User findByEmailAndPassword(String email, String password); 



}
