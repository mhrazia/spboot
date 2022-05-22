package com.tracking.expensetracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tracking.expensetracker.domain.CategoryEntity;
import com.tracking.expensetracker.exception.ETAuthException;
import com.tracking.expensetracker.exception.ETBadRequestException;
import com.tracking.expensetracker.exception.ETResourceNotFoundException;
import com.tracking.expensetracker.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired 
	CategoryRepository repo;
	@Override
	public List<CategoryEntity> getAllCatgories(Integer userid) throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return repo.getAllCategories(userid);
	}

	@Override
	public CategoryEntity getCategoryById(Integer catId) throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity addCategory(Integer userid, String title, String desc) throws ETBadRequestException {
		// TODO Auto-generated method stub
		Integer count = repo.getCategoryCountByUserAndTitle(userid, title);
		if(count > 0) {
			throw new ETBadRequestException("Category is already existing!!");
		}
		Integer catId = repo.addCategory(userid, title, desc);
		return repo.getCategoryById(catId, userid);
	}

	@Override
	public Boolean deleteCategory(Integer userid, Integer catId) throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity updateCategory(Integer catId, Integer userId, String title, String desc)
			throws ETBadRequestException {
		// TODO Auto-generated method stub
		return null;
	}

}
