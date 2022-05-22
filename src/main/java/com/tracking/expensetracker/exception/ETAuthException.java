/**
 * 
 */
package com.tracking.expensetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rafiqmoh
 *
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ETAuthException extends RuntimeException{

	public ETAuthException(String message)
	{
		super(message);
	}
}
