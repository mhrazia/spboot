package com.tracking.expensetracker.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Locale.Category;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tracking.expensetracker.domain.CategoryEntity;
import com.tracking.expensetracker.domain.UserEntity;
import com.tracking.expensetracker.exception.ETAuthException;
import com.tracking.expensetracker.exception.ETBadRequestException;
import com.tracking.expensetracker.exception.ETResourceNotFoundException;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	private static final String GET_ALL_CATEGORIES_BY_USER = "SELECT * FROM ET_CATEGORY WHERE USERID=?";
	private static final String ADD_CATEGORY = "INSERT INTO ET_CATEGORY(CATEGORYID,USERID,TITLE,DESCRIPTION) VALUES(NEXTVAL('ET_CATEGORY_SEQ'),?,?,?)";
	private static final String GET_CATEGORY_BY_ID = "SELECT C.CATEGORYID, C.USERID, C.TITLE, C.DESCRIPTION, COALESCE(SUM(T.AMOUNT), 0) TOTALEXPENSE "
			+ "FROM ET_TRANSACTION T RIGHT OUTER JOIN ET_CATEGORY C ON C.CATEGORYID = T.CATEGORYID WHERE C.CATEGORYID=? AND C.USERID=? GROUP BY C.CATEGORYID";
	@Override
	public Integer addCategory(Integer userid, String title, String desc) throws ETAuthException {
		// TODO Auto-generated method stub
		try {
			KeyHolder holder  = new GeneratedKeyHolder();
			jdbctemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(ADD_CATEGORY, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, userid);
				ps.setString(2,  title);
				ps.setString(3,  desc);
				return ps;
			}, holder);
			return (Integer)holder.getKeys().get("categoryid");
		}catch(Exception e)
		{
			throw new ETBadRequestException("Invalid category details");
		}
	}

	@Override
	public CategoryEntity updateCategory(Integer catid, Integer userid, String title, String desc)
			throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteCategory(Integer catId) throws ETAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryEntity> getAllCategories(Integer userid) throws ETAuthException {
		// TODO Auto-generated method stub
		jdbctemplate.queryForList(GET_ALL_CATEGORIES_BY_USER, new Object[] {userid} );
		return null;
	}

	@Override
	public CategoryEntity getCategoryById(Integer catid, Integer userid) throws ETAuthException {
		// TODO Auto-generated method stub
		return jdbctemplate.queryForObject(GET_CATEGORY_BY_ID, new Object[] {catid, userid}, rowMapper);
	}
	
	
	private RowMapper<CategoryEntity> rowMapper = ((rs, rowNum) -> {
		CategoryEntity cat = new CategoryEntity(rs.getInt("CATEGORYID"),
				rs.getInt("USERID"),
				rs.getString("TITLE"),
				rs.getString("DESCRIPTION"),
				rs.getDouble("TOTALEXPENSE"));
		return cat;
	});
	
	@Override
	public Integer getCategoryCountByUserAndTitle(Integer userid, String title) throws ETBadRequestException {
		// TODO Auto-generated method stub
		
		String GET_CATEGORY_COUNT = "SELECT COUNT(*) FROM ET_CATEGORY WHERE USERID=? AND TITLE=?";
		return jdbctemplate.queryForObject(GET_CATEGORY_COUNT, new Object[] {userid,title}, Integer.class);
	}

	@Override
	public CategoryEntity getCategoryByUserAndTitle(Integer userid, String title) throws ETResourceNotFoundException {
		// TODO Auto-generated method stub
		String GET_CATEGORY_COUNT = "SELECT CATEGORYID, USERID, TITLE, DESCRIPTION FROM ET_CATEGORY WHERE USERID=? AND TITLE=?";
		return jdbctemplate.queryForObject(GET_CATEGORY_COUNT, new Object[] {userid,title}, rowMapper);

	} 
}
