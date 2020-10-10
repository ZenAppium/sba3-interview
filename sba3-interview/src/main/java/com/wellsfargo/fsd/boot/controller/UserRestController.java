package com.wellsfargo.fsd.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.UserException;
import com.wellsfargo.fsd.boot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() throws UserException{			
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}

	/*
	 * @GetMapping("/{id}") public ResponseEntity<User>
	 * getAllUsers(@PathVariable("id") int uid) throws UserException{
	 * ResponseEntity<User> resp = null; User user =userService.getUser(uid);
	 * if(user!=null) { resp = new ResponseEntity<User>(user,HttpStatus.OK); }else {
	 * new ResponseEntity<User>(HttpStatus.NOT_FOUND); } return resp; }
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int uid) throws UserException{			
		userService.deleteUser(uid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> addContact(@RequestBody User user) throws UserException{			
		return new ResponseEntity<User>(userService.add(user), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserException{			
		return new ResponseEntity<User>(userService.add(user), HttpStatus.OK);
	}
}
