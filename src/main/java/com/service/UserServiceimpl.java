package com.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.dao.UserRepository;
import com.model.User;
@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public User register(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public User login(String email, String password) {
		
		User user = userRepo.findByEmail(email).orElse(null);  

	    
	    return user;
	}

	
	@Override
	public User findByUsername(String username) {
		
		return userRepo.findByUsername(username); 
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepo.findById(id).orElseThrow(()->new RuntimeException("user not foundwith id"+id));

	}

	@Override
	public User updateUser(Long id, User user) {
		
		User user1=getUserById(id);
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		if(!userRepo.existsById(id))
		{
			throw new RuntimeException("user not found with id"+id);
		}
		userRepo.deleteById(id);
		
		
	}

	@Override
	public User getOneUserByEmail(String email) {
		
		return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
	}

	@Override
	public User getOneUserPassword(String password) {
		return userRepo.findByPassword(password);
	}


	
	
	

}


	
	
	


