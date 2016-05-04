package com.estsoft.jblog.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.BlogUserVo;

@Repository
public class BlogUserDao {
	@Autowired
	private SqlSession sqlSession;

	public void insert( BlogUserVo blogUserVo ) {
		sqlSession.insert("bloguser.insert", blogUserVo );
	}
	
	public void delete( BlogUserVo blogUserVo ) {
		sqlSession.delete("bloguser.delete", blogUserVo );
	}
	
	public void update( BlogUserVo blogUserVo ) {
		sqlSession.update("bloguser.update", blogUserVo );
	}
	
	public BlogUserVo get( long userNo ) {
		return sqlSession.selectOne("bloguser.getByNo", userNo);
	}
	
	public BlogUserVo get( BlogUserVo blogUserVo ) {
		return sqlSession.selectOne("bloguser.getByNamePassword", blogUserVo);
	}
	
	public BlogUserVo get( String userName ) {
		Map<String, Object> map = new HashMap<String, Object>( );
		map.put("userName", userName);
		return sqlSession.selectOne("bloguser.getByName", map);
	}

}
