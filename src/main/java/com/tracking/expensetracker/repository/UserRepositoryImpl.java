package com.tracking.expensetracker.repository;


import java.sql.PreparedStatement;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tracking.expensetracker.domain.UserEntity;
import com.tracking.expensetracker.exception.ETAuthException;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final String INSERT_USER = "INSERT INTO ET_USER(USERID,FNAME,LNAME,EMAIL,PASSWORD) VALUES(NEXTVAL('ET_USER_SEQ'),?,?,?,?)";
	private static final String FIND_BY_ID = "SELECT USERID, FNAME, LNAME, EMAIL, PASSWORD FROM ET_USER WHERE USERID=?";
	private static final String GET_EMAIL_COUNT = "SELECT COUNT(*) FROM ET_USER WHERE EMAIL=?";
	private static final String FIND_BY_EMAIL ="SELECT USERID, FNAME, LNAME, EMAIL, PASSWORD FROM ET_USER WHERE EMAIL=?";
	
	private RowMapper<UserEntity> rowMapper = ((rs, rowNum) ->{
		return new UserEntity(rs.getInt("USERID"),
				rs.getString("FNAME"),
				rs.getString("LNAME"),
				rs.getString("EMAIL"),
				rs.getString("PASSWORD"));
	});
	
	@Autowired
	JdbcTemplate jdbctemplate;

	
	@Override
	public Integer createUser(String fname, String lname, String email, String password) throws ETAuthException {
		// TODO Auto-generated method stub
		try {
			KeyHolder holder = new GeneratedKeyHolder();
			jdbctemplate.update( connection -> {
				PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,  fname);
				ps.setString(2,  lname);
				ps.setString(3,  email);
				ps.setString(4,  BCrypt.hashpw(password, BCrypt.gensalt(10)));
				return ps;
			}, holder);
			return (Integer) holder.getKeys().get("USERID");
		}catch(Exception e) {
			throw new ETAuthException("Invalid user details");
		}		
	}

	@Override
	public UserEntity findByEmailAndPassword(String email, String password) throws ETAuthException {
		// TODO Auto-generated method stub
		try {
			UserEntity user = jdbctemplate.queryForObject(FIND_BY_EMAIL, new Object[] {email}, rowMapper);
			if(!BCrypt.checkpw(password, user.getPassword())) {
				throw new ETAuthException("Invalid password!!!");
			}
			return user;
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			throw new ETAuthException("User not registered");
		}		
	}

	@Override
	public Integer getEmailCount(String email) throws ETAuthException {
		// TODO Auto-generated method stub
		return jdbctemplate.queryForObject(GET_EMAIL_COUNT, new Object[]{email},Integer.class);
	}

	@Override
	public UserEntity findByUserId(Integer id) throws ETAuthException {
		// TODO Auto-generated method stub
		return jdbctemplate.queryForObject(FIND_BY_ID, new Object[]{id}, rowMapper);

	}
	

}
