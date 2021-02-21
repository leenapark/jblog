package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	// id check
	public String idcheck(String id) {
		System.out.println("UserService idcheck" + id);
		
		UserVo userVo = userDao.selectOne(id);
		
		String result = "";
		
		if(userVo == null) {
			result = "can";
		} else {
			result = "cant";
		}
		
		
		
		return result;
	}
	

	// 회원가입을 할경우 자동으로 블로그를 생성해야 한다
	public void joinBlog(UserVo userVo) {
		System.out.println("UserService joinBlog: " + userVo);
		
		String blogTitle = userVo.getUserName();
		userVo.setBlogTitle(blogTitle);
		userVo.setLogoFile("/assets/images/spring-logo.jpg");
		
		userDao.insert(userVo);
		
	}
	
	
	
}
