package com.wellsfargo.fsd.boot.service;

import java.util.List;

import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.UserException;

public interface UserService {

	User add(User user) throws UserException;
	User save(User user) throws UserException;
	
	boolean deleteUser(int userId) throws UserException;
	
	User getUser(int userId) throws UserException;
	List<User> getAllUsers() throws UserException;
}
