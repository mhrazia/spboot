package com.tracking.expensetracker.repository;

import java.util.List;

import com.tracking.expensetracker.domain.CategoryEntity;
import com.tracking.expensetracker.exception.ETAuthException;
import com.tracking.expensetracker.exception.ETBadRequestException;
import com.tracking.expensetracker.exception.ETResourceNotFoundException;

public interface CategoryRepository {
	public abstract Integer addCategory(Integer userid, String title, String desc) throws ETBadRequestException;
	public abstract CategoryEntity updateCategory(Integer catid, Integer userid, String title, String desc) throws ETBadRequestException;
	public abstract Boolean deleteCategory(Integer catId) throws ETResourceNotFoundException;
	public abstract List<CategoryEntity> getAllCategories(Integer userid) throws ETResourceNotFoundException;
	public abstract CategoryEntity getCategoryById(Integer catid, Integer userid) throws ETResourceNotFoundException;
	public abstract Integer getCategoryCountByUserAndTitle(Integer userid, String title) throws ETBadRequestException;
	public abstract CategoryEntity getCategoryByUserAndTitle(Integer userid, String title) throws ETResourceNotFoundException;
	
}
