package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService cateService;
	
	// 블로그 메인
	// postNo 와 cateNo를 다 가지고 있는 PostVo 를 사용
	@RequestMapping(value="/{id}", method= {RequestMethod.GET, RequestMethod.POST})
	public String blog(@PathVariable("id") String id, @ModelAttribute PostVo postVo, Model model) {
		System.out.println("BlogController: " + id + ", " + postVo);
		
		
		UserVo blogVo = blogService.selectBlog(id);
		
		Map<String, Object> catepostMap = cateService.cateList(id, postVo);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("catepostMap", catepostMap);
		
		return "/blog/blog-main";
	}
	
	// 내 블로그 관리
	@RequestMapping(value="/{id}/admin/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public String adminBasic(@PathVariable("id") String id, Model model) {
		System.out.println("AdminController");
		
		UserVo blogVo = blogService.selectBlog(id);
		model.addAttribute("blogVo", blogVo);
		
		
		return "/blog/admin/blog-admin-basic";
	}
	

}
