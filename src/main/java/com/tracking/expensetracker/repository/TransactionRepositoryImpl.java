package com.tracking.expensetracker.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tracking.expensetracker.domain.TransactionEntity;
import com.tracking.expensetracker.exception.ETBadRequestException;
import com.tracking.expensetracker.exception.ETResourceNotFoundException;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@Override
	public List<TransactionEntity> getAllTransactions() throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionEntity> getAllTransactionsByUser(Integer userid) throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionEntity> getAllTransactionsByUserAndCategory(Integer userid, Integer catid)
			throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionEntity getTransactionById(Integer transId, Integer catId, Integer userid)
			throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addTransaction(Integer userid, Integer catid, double amount, String desc)
			throws ETBadRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTransaction(Integer userid, Integer catId, Integer transid, double amount, String desc,
			long addedTime) throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionEntity updateTransaction(Integer userid, Integer catid, Integer transid)
			throws ETBadRequestException {
		// TODO Auto-generated method stub
		return null;
	}

}
