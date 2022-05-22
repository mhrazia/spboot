package com.tracking.expensetracker.services;

import java.util.List;

import com.tracking.expensetracker.domain.CategoryEntity;
import com.tracking.expensetracker.exception.ETAuthException;
import com.tracking.expensetracker.exception.ETBadRequestException;
import com.tracking.expensetracker.exception.ETResourceNotFoundException;

public interface CategoryService {
	public abstract List<CategoryEntity> getAllCatgories(Integer userid) throws ETResourceNotFoundException;
	public abstract CategoryEntity getCategoryById(Integer catId) throws ETResourceNotFoundException;
	public abstract CategoryEntity addCategory(Integer userid, String title, String desc) throws ETBadRequestException;
	public abstract Boolean deleteCategory(Integer userid, Integer catId) throws ETResourceNotFoundException;
	public abstract CategoryEntity updateCategory(Integer catId, Integer userId, String title, String desc) throws ETResourceNotFoundException;
}
