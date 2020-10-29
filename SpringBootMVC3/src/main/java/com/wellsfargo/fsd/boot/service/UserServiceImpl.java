package com.wellsfargo.fsd.boot.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wellsfargo.fsd.boot.dao.UserRepository;
import com.wellsfargo.fsd.boot.dto.UserDto;
import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.UserException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	private User toUserEntity(UserDto userDto) {
		return new User(userDto.getUserId(),userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),userDto.getMobile());
	}
	
	private UserDto toUserModel(User user) {
		return new UserDto(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getMobile());
	}
	
	
	@Override
	@Transactional
	public UserDto addUser(UserDto userDto) throws UserException {
		if(userDto!=null) {
			if(userRepo.existsById(userDto.getUserId())) {
				throw new UserException("User Id already in use!");
			}
			userDto = toUserModel(userRepo.save(toUserEntity(userDto)));
		}
		return userDto;
	}
	
	@Override
	public UserDto getUser(int userId) throws UserException {
		User user = userRepo.findById(userId).orElse(null);	
		return user!=null?toUserModel(user):null;
	}

	@Override
	@Transactional
	public boolean deleteUser(int userId) throws UserException {
		if(!userRepo.existsById(userId)) {
			throw new UserException("User Id is not found!");
		}
		userRepo.deleteById(userId);
		return true;
	}

	@Override
	public List<UserDto> getAllUsers() throws UserException {
		List<User> user = userRepo.findAll();
		List<UserDto> userDto = null;
		if(user!=null && !(user.isEmpty())) {
			userDto = user.stream().map(e -> toUserModel(e)).collect(Collectors.toList());
		}
		return userDto;
	}
	
}
