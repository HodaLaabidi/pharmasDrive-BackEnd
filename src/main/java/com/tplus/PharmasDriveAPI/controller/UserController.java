package com.tplus.PharmasDriveAPI.controller;



import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tplus.PharmasDriveAPI.model.User;
import com.tplus.PharmasDriveAPI.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService uService;

	
	
	
	@GetMapping( "/users")

	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(uService.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		
		return new ResponseEntity<User>(uService.getUser(id), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteUser(@RequestParam String id) {
		
		uService.deleteUser(id);
		return new  ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	

	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		return new ResponseEntity<User>(uService.registerUser(user), HttpStatus.CREATED);
	}


	@CrossOrigin
	@PostMapping("/users/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user) {
		
		return new ResponseEntity<User>(uService.loginUser(user), HttpStatus.OK);
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return  new ResponseEntity<User>(uService.updateUser(user), HttpStatus.OK);
	}
	
}
