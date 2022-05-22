package com.tracking.expensetracker.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tracking.expensetracker.domain.TransactionEntity;
import com.tracking.expensetracker.exception.ETAuthException;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Override
	public List<TransactionEntity> getAllTransactions() throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionEntity> getAllTransactionsByUser(Integer userid) throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionEntity> getAllTransactionsByUserAndCategory(Integer userid, Integer catid)
			throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionEntity getTransactionById(Integer transId, Integer catId, Integer userid) throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addTransaction(Integer userid, Integer catid, double amount, String desc) throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTransaction(Integer userid, Integer catId, Integer transid, double amount, String desc,
			long addedTime) throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionEntity updateTransaction(Integer userid, Integer catid, Integer transid) throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

}
