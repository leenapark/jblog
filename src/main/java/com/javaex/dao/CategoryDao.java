package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 회원가입할 때 블로그 생성되면서 카테고리값 주어짐
	public void insertCate(CategoryVo cateVo) {
		System.out.println("CategoryDao: " + cateVo);
		
		sqlSession.insert("category.insertCate", cateVo);
	}

	
	public List<CategoryVo> categoryList(String id){
		System.out.println("CategoryDao: " + id);
		
		return sqlSession.selectList("category.selectCateList", id);
	}
}
