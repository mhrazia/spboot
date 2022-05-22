package com.tracking.expensetracker.services;

import java.util.List;

import com.tracking.expensetracker.domain.TransactionEntity;
import com.tracking.expensetracker.exception.ETAuthException;

public interface TransactionService {
	public abstract List<TransactionEntity> getAllTransactions() throws ETAuthException;
	public abstract List<TransactionEntity> getAllTransactionsByUser(Integer userid) throws ETAuthException;
	public abstract List<TransactionEntity> getAllTransactionsByUserAndCategory(Integer userid, Integer catid) throws ETAuthException;
	public abstract TransactionEntity getTransactionById(Integer transId, Integer catId, Integer userid) throws ETAuthException;
	public abstract Integer addTransaction(Integer userid, Integer catid, double amount, String desc) throws ETAuthException;
	public abstract Boolean deleteTransaction(Integer userid, Integer catId, Integer transid, double amount, String desc, long addedTime) throws ETAuthException;
	public abstract TransactionEntity updateTransaction(Integer userid, Integer catid, Integer transid) throws ETAuthException;
}
