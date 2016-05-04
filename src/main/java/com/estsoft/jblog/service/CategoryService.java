package com.estsoft.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.dao.CategoryDao;
import com.estsoft.jblog.vo.CategoryVo;

@Repository
public class CategoryService {
	@Autowired
	private CategoryDao dao;
	
	public void createCategory( CategoryVo categoryVo ) {
		dao.insert(categoryVo);
	}
	
	public void deleteCategory( long categoryNo ) {
		dao.delete(categoryNo);
	}
	
	public void deleteCategory( String categoryName ) {
		dao.delete(categoryName);
	}
	
	public void deleteCategorys( long blogNo ) {
		dao.deleteAll(blogNo);
	}
	
	public void modifyCategory( long categoryNo ) {
		dao.update(categoryNo);
	}
	
	public List<CategoryVo> showCategoryList( long blogNo ) {
		return dao.get(blogNo);
	}
	
	public CategoryVo getCategory( String categoryName ) {
		return dao.get(categoryName);
	}
}
