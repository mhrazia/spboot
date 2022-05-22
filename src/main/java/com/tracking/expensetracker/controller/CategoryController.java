package com.tracking.expensetracker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.expensetracker.domain.CategoryEntity;
import com.tracking.expensetracker.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@GetMapping("")
	public ResponseEntity<List<CategoryEntity>> getAllCategoreis(HttpServletRequest request)
	{
		List<CategoryEntity> catList = new ArrayList<CategoryEntity>();
		
		Integer userId = (Integer)request.getAttribute("userid");
		if(userId > 0) {
			catList = service.getAllCatgories(userId);
			if(catList == null  || catList.size() == 0) {
				return new ResponseEntity<List<CategoryEntity>>(catList, HttpStatus.NO_CONTENT);
			}
		}
		
		return new ResponseEntity<List<CategoryEntity>>(catList, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CategoryEntity> addNewCategory(HttpServletRequest request, @RequestBody Map<String, Object> catMap)
	{
		int userid = (Integer)request.getAttribute("userid");
		String title = (String)catMap.get("title");
		String desc = (String)catMap.get("description");
		CategoryEntity cat = service.addCategory(userid, title, desc);
		return new ResponseEntity<CategoryEntity>(cat, HttpStatus.CREATED);
	}
}
