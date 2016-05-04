package com.estsoft.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.jblog.dao.BlogDao;
import com.estsoft.jblog.vo.BlogVo;

@Service
public class BlogService {
	@Autowired
	private BlogDao dao;
	
	public void createBlog( BlogVo blogVo ) {
		dao.insert(blogVo);
	}
	
	public void deleteBlog( long userNo ) {
		dao.delete(userNo);
	}
	
	public void modifyBlog( BlogVo blogVo ) {
		dao.update(blogVo);
	}
	
	public BlogVo getBlog( long userNo ) {
		return dao.get(userNo);
	}
	
	public BlogVo getBlog( String userName ) {
		return dao.get(userName);
	}

}
