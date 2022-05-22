package com.tracking.expensetracker.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.expensetracker.ETConstants;
import com.tracking.expensetracker.domain.UserEntity;
import com.tracking.expensetracker.services.UserService;
import com.tracking.expensetracker.services.UserServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
//	@Autowired
//	UserServiceImpl service  = new UserServiceImpl();
	
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userDetails) {
		String fName = (String) userDetails.get("fname");
		String lName = (String) userDetails.get("lname");
		String email = (String) userDetails.get("email");
		String pwd = (String) userDetails.get("password");
		
		UserEntity user = service.registerUser(fName, lName, email, pwd);
		//Map<String, String> map = new HashMap<String, String>();
		//map.put("message", "user created successfully");
		return new ResponseEntity<Map<String,String>>(generateToken(user), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userDetails) {
		String email = (String) userDetails.get("email");
		String pwd = (String) userDetails.get("password");
		UserEntity user = service.validateUser(email, pwd);
		//Map<String, String> map  = new HashMap<String, String>();
		//map.put("message", "User logged in successfully");
		
		return new ResponseEntity<Map<String,String>>(generateToken(user), HttpStatus.OK);
	}
	
	private Map<String, String> generateToken(UserEntity user)
	{
		long currentTime = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, ETConstants.ET_TOKEN_KEY)
				.setIssuedAt(new Date(currentTime))
				.setExpiration(new Date(currentTime + ETConstants.ET_TOKEN_VALIDITY))
				.claim("userid", user.getUserId())
				.claim("fname", user.getFirstName())
				.claim("lname", user.getLastName())
				.claim("email", user.getEmailId())
				.compact();
		System.out.println("Token : "+token);
		Map<String, String> map = new HashMap<String, String>();
		map.put("token", token);
		return map;
	}
}
