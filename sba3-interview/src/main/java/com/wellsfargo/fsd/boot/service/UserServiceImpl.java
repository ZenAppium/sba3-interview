package com.wellsfargo.fsd.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.fsd.boot.dao.UserRepository;
import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.UserException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	@Transactional
	public User add(User user) throws UserException {
		if(user!=null) {
			if(userRepo.existsById(user.getUserId())) {
				throw new UserException("Contact Id already in use!");
			}
			/*
			 * if(userRepo.existsByMobile(user.getMobile())) { throw new
			 * UserException("Mobile Number is already in use!"); }
			 */
			userRepo.save(user);
		}
		return user;
	}

	@Override
	@Transactional
	public User save(User user) throws UserException {
		if(user!=null) {
			if(!userRepo.existsById(user.getUserId())) {
				throw new UserException("Contact Id is not found!");
			}
			userRepo.save(user);
		}
		return user;
	}

	@Override
	@Transactional
	public boolean deleteUser(int userId) throws UserException {
		if(!userRepo.existsById(userId)) {
			throw new UserException("Contact Id is not found!");
		}
		userRepo.deleteById(userId);
		return true;
	}

	@Override
	public User getUser(int userId) throws UserException {
		return userRepo.findById(userId).orElse(null);
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		return userRepo.findAll();
	}
	
}
