package com.javaex.controller;


import javax.servlet.http.HttpSession;

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
		
		userService.joinBlog(userVo);
		System.out.println("등록 후: " + userVo);
		
		
		return "/user/joinSuccess";
	}
	
	
	// 로그인 폼
	@RequestMapping(value="/loginform", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController loginForm");
		
		return "/user/loginForm";		
	}
	
	// 로그인
	@RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController login");
		UserVo authUser = userService.login(userVo);
		
		if(authUser == null) {
			System.out.println("로그인 실패");
			
			return "redirect:/user/loginForm?result=fail";
			
		} else {
			System.out.println("로그인 성공");

			session.setAttribute("authUser", authUser);
			
			return "redirect:/";
		}

	}
	
}
