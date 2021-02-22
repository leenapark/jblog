package com.javaex.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class BlogService {

	@Autowired
	private UserDao userDao;
	
	
	// 블로그 정보 가져오기
	public UserVo selectBlog(String id) {
		
		
		return userDao.selectBlog(id);
		
	}
	
	
}
