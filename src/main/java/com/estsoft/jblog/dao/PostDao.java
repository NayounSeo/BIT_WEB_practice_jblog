package com.estsoft.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.PostVo;

@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert( PostVo postVo ) {
		sqlSession.insert("post.insert", postVo);
	}
	
	public void deleteOne( long postNo ) {
		sqlSession.delete("post.deleteOne", postNo);
	}
	
	public void deleteAll( long categoryNo ) {
		sqlSession.delete("post.deleteOne", categoryNo);
	}
	
	public PostVo getByNo( long postNo ) {
		return sqlSession.selectOne("post.getByNo", postNo);
	}
	
	public List<PostVo> getByCategory( long categoryNo ) {
		List<PostVo> list = sqlSession.selectList("post.getByCategoryNoList", categoryNo);
		return list;
	}
	
	public long getFirst( long categoryNo ) {
		return sqlSession.selectOne("post.getFirstPostOfCategory", categoryNo );
	}
	
}

