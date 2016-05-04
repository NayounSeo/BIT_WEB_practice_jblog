package com.estsoft.jblog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert( CategoryVo categoryVo ) {
		sqlSession.insert("category.insert", categoryVo);
	}
	
	//어.. 내가 낫 널로 설정해놔서 좀 그런가 아닌데
	//이거 그냥 ModelAttribute로 받으면 둘 중 하나... Null이면 에러나나 모르겠당 ㅎㅅㅎ...
	// TODO 질문으로 하자.
	public void delete( long categoryNo ) {
		sqlSession.delete("category.deleteByNo", categoryNo);
	}
	
	public void delete( String categoryName ) {
		Map<String, Object> map = new HashMap<String, Object>( );
		map.put("categoryName", categoryName);
		sqlSession.delete("category.deleteByName", categoryName);
	}
	
	public void deleteAll( long blogNo ) {
		sqlSession.delete("category.deleteByBlogNo", blogNo);
	}
	
	public void update( long categoryNo ) {
		sqlSession.update("category.update", categoryNo);
	}
	
	public int getPostCount( long categoryNo ) {
		return sqlSession.selectOne("category.getPostCount", categoryNo);
	}
	
	/*public CategoryVo get( long categoryNo ) {
		return sqlSession.selectOne("category.getByNo", categoryNo);
	}*/
	
	public List<CategoryVo> get( long blogNo ) {
		List<CategoryVo> list = sqlSession.selectList("category.getList");	
		return list;
	}
	
	public CategoryVo get( String categoryName ) {
		return sqlSession.selectOne("category.getByName", categoryName);
	}
}
