package com.tracking.expensetracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.expensetracker.domain.TransactionEntity;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	@GetMapping("")
	public List<TransactionEntity> getAllTransactions()
	{
		List<TransactionEntity> transList = new ArrayList<TransactionEntity>();
		return transList;
	}
	
}
