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

	// 회원가입
	/* 회원가입하면 블로그가 생성되고 블로그가 생성되면 기본으로 미분류 카테고리가 생성되어야 함 */
	public void insert(UserVo userVo) {
		System.out.println("UserDao: " + userVo);

		sqlSession.insert("user.insertUser", userVo);
		sqlSession.insert("user.insertBlog", userVo);

	}

	// login
	public UserVo selectOne(UserVo userVo) {
		System.out.println("UserDao: " + userVo);

		return sqlSession.selectOne("user.selectLogin", userVo);

	}

	// 선택한 블로그 정보 가져오기
	public UserVo selectBlog(String id) {
		System.out.println("UserService selectBlog" + id);

		return sqlSession.selectOne("user.selectBlog", id);
	}

}
