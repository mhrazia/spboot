/**
 * 
 */
package com.tracking.expensetracker.domain;

import java.math.BigDecimal;

/**
 * @author rafiqmoh
 *
 */
public class TransactionEntity {
	private Integer transactionId;
	private Integer categoryId;
	private Integer userId;
	private double amount;
	private String remark;
	private BigDecimal transactionDate;
	/**
	 * @param transactionId
	 * @param categoryId
	 * @param userId
	 * @param amount
	 * @param remark
	 * @param transactionDate
	 */
	public TransactionEntity(Integer transactionId, Integer categoryId, Integer userId, double amount, String remark,
			BigDecimal transactionDate) {
		this.transactionId = transactionId;
		this.categoryId = categoryId;
		this.userId = userId;
		this.amount = amount;
		this.remark = remark;
		this.transactionDate = transactionDate;
	}
	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the transactionDate
	 */
	public BigDecimal getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(BigDecimal transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
