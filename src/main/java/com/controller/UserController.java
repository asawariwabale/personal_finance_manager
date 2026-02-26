package com.controller;

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


import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000") 

public class UserController {

	
	
	@Autowired
    private UserService userservice;
	
	@PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
       
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.register(user));
    }

	
	/*@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
	    return ResponseEntity.ok(userservice.login(user.getEmail(), user.getPassword()));
	}*/
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
	    try {
	        User loggedInUser = userservice.login(user.getEmail(), user.getPassword());
	        if (loggedInUser == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                                 .body("Invalid email or password");
	        }
	        return ResponseEntity.ok(loggedInUser);
	    } catch (Exception e) {
	        // Log the exception for debugging
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Server error: " + e.getMessage());
	    }
	}
	
	
	
	 @GetMapping("/find/{username}")
     public User getUserByUsername(@PathVariable String username)
     {
    	 return userservice.findByUsername(username);
     }
     
     @GetMapping("get/{id}")
     public ResponseEntity<?>getUserById(@PathVariable Long id)
     {
    try
     {
    	return ResponseEntity.ok(userservice.getUserById(id)); 
     }catch(RuntimeException ex)
     {
    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
     }
    }
     
     @DeleteMapping("delete/{id}")
     public ResponseEntity<String> deleteUser(@PathVariable Long id)
    
     {
    	 try
     {
    	userservice.deleteUser(id);
    	return ResponseEntity.ok("user delete successfully");
     }
    	 catch(RuntimeException ex)
    	 {
    		 return ResponseEntity.status(404).body("user not found");
    	 }

     }
     
     @PutMapping("update/{id}")
     public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User users)
     {
    	 try {
    		 return ResponseEntity.ok(userservice.updateUser(id,users));
    		 
    	 }catch(RuntimeException ex)
    	 {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(users);
    	 }
     }
     
     
     @GetMapping("/email/{email}")
     public User getOneUserByEmail(@PathVariable String email)
     {
    	 return userservice.getOneUserByEmail(email);
     }
	
     
     @GetMapping("/getOneUserpassword/{password}")
     public ResponseEntity<User> getOneByUserpassword(@PathVariable String password) {

         User u= userservice.getOneUserPassword(password);

         return ResponseEntity
                 .status(HttpStatus.OK)
                 .header("get", "get one record by password")
                 .body(u);
     }


}
