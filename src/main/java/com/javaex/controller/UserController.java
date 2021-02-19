package com.javaex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	// 회원 가입 폼
	@RequestMapping(value="/joinform", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController joinForm");
		
		return "/user/joinForm";
	}
	
	// idcheck
	@ResponseBody
	@RequestMapping(value="/idcheck", method = {RequestMethod.GET, RequestMethod.POST})
	public String idcheck(@RequestParam("id") String id) {
		System.out.println("UserController idcheck: " + id);
		
		String result = userService.idcheck(id);
		
		System.out.println("UserController idcheck: " + result);
		
		return result;
	}
	
	// 회원가입
	@RequestMapping(value="/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController join: " + userVo);
		
		
		
		return "";
	}
	
	
}
