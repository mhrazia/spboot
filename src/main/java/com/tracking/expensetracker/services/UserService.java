package com.tracking.expensetracker.services;

import com.tracking.expensetracker.domain.UserEntity;
import com.tracking.expensetracker.exception.ETAuthException;

public interface UserService {

	public abstract UserEntity validateUser(String email, String password) throws ETAuthException;
	public abstract UserEntity registerUser(String fname, String lname, String email, String password) throws ETAuthException;
}
