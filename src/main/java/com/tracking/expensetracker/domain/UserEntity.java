/**
 * 
 */
package com.tracking.expensetracker.domain;

/**
 * @author rafiqmoh
 *
 */
public class UserEntity {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	
	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param emailId
	 * @param password
	 */
	public UserEntity(Integer userId, String firstName, String lastName, String emailId, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
