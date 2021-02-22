package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao cateDao;
	
	@Autowired
	private PostDao postDao;
	
	// 카테고리 리스트 가져오기
	public Map<String, Object> cateList(String id, PostVo postVo) {
		System.out.println("CategoryService cateList: " + id + ", " + postVo);
		
		Map<String, Object> catepostMap = new HashMap<String, Object>();
		
		List<CategoryVo> cateList = cateDao.categoryList(id);
		catepostMap.put("cateList", cateList);
		
		int cateNo = postVo.getCateNo();
		
		// 카테고리 리스트 상단은 최근 카테고리가 차지한다.
		if(cateNo == 0) {
			cateNo = cateList.get(0).getCateNo();
			System.out.println("CategoryService cateNo: " + cateNo);
		}
		
		// 카테고리에 post가 연결되어 있어 글 목록이 보여야함
		// 가장 최근 포스트가 상단에 위치해야함
		List<PostVo> postList = postDao.selectPostList(cateNo);
		System.out.println("CategoryService postList: " + postList);
		catepostMap.put("postList", postList);
		
	
		if(postList.size() != 0) {
			int postNo = postVo.getPostNo();
			
			if(postNo == 0) {	// 기본 값에서 상단에 가장 최근글을 놓아야 한다
				postNo = postList.get(0).getPostNo();
			}
			
			postVo = postDao.selectPost(postNo);
			
			catepostMap.put("postVo", postVo);
			
			System.out.println("cateList map: " + catepostMap);
		}
		
		
		return catepostMap;
		
	}
	
}
