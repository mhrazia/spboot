package com.tracking.expensetracker.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tracking.expensetracker.domain.UserEntity;
import com.tracking.expensetracker.exception.ETAuthException;
import com.tracking.expensetracker.repository.UserRepository;
import com.tracking.expensetracker.repository.UserRepositoryImpl;

@Service
@Transactional
public class UserServiceImpl implements UserService{

//	@Autowired
//	UserRepositoryImpl userRepo = new UserRepositoryImpl();
	@Autowired
	UserRepository userRepo;
	@Override
	public UserEntity validateUser(String email, String password) throws ETAuthException {
		// TODO Auto-generated method stub
		UserEntity user = userRepo.findByEmailAndPassword(email, password);
		return user;
	}

	@Override
	public UserEntity registerUser(String fname, String lname, String email, String password) throws ETAuthException {
		// TODO Auto-generated method stub
		Pattern emailPattern = Pattern.compile("^(.+)@(.+).(.+)$");
		if(email != null) email = email.toLowerCase();
		if(!emailPattern.matcher(email).matches())
			throw new ETAuthException("Invalid email format");
		if(userRepo.getEmailCount(email).intValue() > 0)
			throw new ETAuthException("Email already in use");
		Integer id = userRepo.createUser(fname, lname, email, password);
		return userRepo.findByUserId(id);
 	}

}
