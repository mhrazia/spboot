package com.tracking.expensetracker.repository;

import java.util.List;

import com.tracking.expensetracker.domain.TransactionEntity;
import com.tracking.expensetracker.exception.ETAuthException;
import com.tracking.expensetracker.exception.ETBadRequestException;
import com.tracking.expensetracker.exception.ETResourceNotFoundException;

public interface TransactionRepository {

	public abstract List<TransactionEntity> getAllTransactions() throws ETResourceNotFoundException;
	public abstract List<TransactionEntity> getAllTransactionsByUser(Integer userid) throws ETResourceNotFoundException;
	public abstract List<TransactionEntity> getAllTransactionsByUserAndCategory(Integer userid, Integer catid) throws ETResourceNotFoundException;
	public abstract TransactionEntity getTransactionById(Integer transId, Integer catId, Integer userid) throws ETResourceNotFoundException;
	public abstract Integer addTransaction(Integer userid, Integer catid, double amount, String desc) throws ETBadRequestException;
	public abstract Boolean deleteTransaction(Integer userid, Integer catId, Integer transid, double amount, String desc, long addedTime) throws ETResourceNotFoundException;
	public abstract TransactionEntity updateTransaction(Integer userid, Integer catid, Integer transid) throws ETBadRequestException;

}
