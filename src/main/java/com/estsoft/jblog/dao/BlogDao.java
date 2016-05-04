package com.estsoft.jblog.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert( BlogVo blogVo ) {
		sqlSession.insert("blog.insert", blogVo);
	}
	
	public void delete( long userNo ) {
		sqlSession.delete("blog.delete", userNo);
	}
	
	public void update( BlogVo blogVo ) {
		sqlSession.update("blog.update", blogVo);
	}
	
	public BlogVo get( long userNo ) {
		return sqlSession.selectOne("blog.getByBlogNo", userNo);
	}
	
	public BlogVo get( String userName ) {
		Map<String, Object> map = new HashMap<String, Object>( );
		map.put("userName", userName);
		return sqlSession.selectOne("blog.getByUserName", map);
	}

}
