package com.firebase.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firebase.model.Users;
import com.firebase.service.FirebaseService;

@RestController
public class UserController {
	
	@Autowired
	FirebaseService firebaseService;
	
	@PostMapping("/users")
	public String createUser(@RequestBody Users users) throws InterruptedException, ExecutionException {
		return firebaseService.saveUserDetails(users);
	}
		
	@GetMapping("/users")
	public Users getUserDetails(@RequestHeader String name) throws InterruptedException, ExecutionException {
		return firebaseService.getUserDetails(name);
	}
	
	@PutMapping("/users")
	public String UpdateUser(@RequestBody Users user) throws InterruptedException, ExecutionException {
		return firebaseService.updateUserDetails(user);
	}
	
	@DeleteMapping("/users")
	public String deleteUser(@RequestHeader String name) {
		return firebaseService.deleteuser(name);
	}

}
