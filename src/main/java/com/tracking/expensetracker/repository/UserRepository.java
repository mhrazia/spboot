package com.tracking.expensetracker.repository;

import com.tracking.expensetracker.domain.UserEntity;
import com.tracking.expensetracker.exception.ETAuthException;

public interface UserRepository {

	Integer createUser(String fname, String lname, String email, String password) throws ETAuthException;
	UserEntity findByEmailAndPassword(String email, String password) throws ETAuthException;
	Integer getEmailCount(String email) throws ETAuthException;
	UserEntity findByUserId(Integer id) throws ETAuthException;
}
