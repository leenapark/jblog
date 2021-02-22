package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	// postList
	public List<PostVo> selectPostList(int cateNo)	{
		System.out.println("PostDao selectPostList: " + cateNo);
		
		
		return sqlSession.selectList("post.selectPostList", cateNo);
	}
	
	public PostVo selectPost(int postNo) {
		System.out.println("PostDao selectPost");
		
		return sqlSession.selectOne("post.selectPost", postNo);
	}
}
