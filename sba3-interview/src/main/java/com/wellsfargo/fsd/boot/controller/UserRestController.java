package com.wellsfargo.fsd.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.fsd.boot.dto.UserDto;
import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.UserException;
import com.wellsfargo.fsd.boot.service.UserConverter;
import com.wellsfargo.fsd.boot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;

	@GetMapping
	public List<UserDto> getAllUsers() throws UserException{			
		List<User> getAllUsers = userService.getAllUsers();
		return userConverter.entityToDto(getAllUsers);
	}

	@DeleteMapping("/{id}") 
	public void deleteUser(@PathVariable("id") int uid) throws UserException{
		userService.deleteUser(uid);
	}

	@PostMapping
	public UserDto addUser(@RequestBody @Valid UserDto userDto) throws UserException{
		User user = userConverter.dtoToEntity(userDto);
		user = userService.add(user);
		return userConverter.entityToDto(user);
	}

	@PutMapping 
	public UserDto saveUser(@RequestBody @Valid UserDto userDto) throws UserException{  
		User user = userConverter.dtoToEntity(userDto);
		user = userService.save(user);
		return userConverter.entityToDto(user);
	}

}
