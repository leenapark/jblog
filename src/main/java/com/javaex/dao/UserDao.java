package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// id check
	public UserVo selectOne(String id) {
		
		return sqlSession.selectOne("user.idcheck", id);
	}
	

}