package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	
public User register(User user);
	
	public User login(String email,String password);
	
	public User findByUsername(String username);

   public  User getUserById(Long id);

    public void deleteUser(Long id);

   public User updateUser(Long id, User user);

  public List<User> getAllUsers();
  
 public User getOneUserByEmail(String email);

 public User getOneUserPassword(String password);





}
