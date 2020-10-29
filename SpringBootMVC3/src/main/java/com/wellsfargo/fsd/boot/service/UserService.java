package com.wellsfargo.fsd.boot.service;

import java.util.List;

import com.wellsfargo.fsd.boot.dto.UserDto;
import com.wellsfargo.fsd.boot.exception.UserException;

public interface UserService {

	UserDto addUser(UserDto user) throws UserException;
	UserDto getUser(int userId) throws UserException;
	boolean deleteUser(int userId) throws UserException;
	List<UserDto> getAllUsers() throws UserException;
}
