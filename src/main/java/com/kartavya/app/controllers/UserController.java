package com.kartavya.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kartavya.app.entity.User;
import com.kartavya.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//CRUD Operations
	
	@GetMapping("/api/v1/all")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/api/v1/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/api/v1")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/api/v1/{id}")
	public String editUser(	@PathVariable int id,
							@RequestBody User newUser) {
		return userService.editUser( id,newUser);
	}
	
	@DeleteMapping("/api/v1/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	
	@DeleteMapping("/api/v1/all")
	public String deleteAll() {
		return userService.deleteAll();
	}

}
