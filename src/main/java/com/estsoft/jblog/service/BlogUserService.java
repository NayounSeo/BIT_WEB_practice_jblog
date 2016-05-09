package com.estsoft.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.jblog.dao.BlogUserDao;
import com.estsoft.jblog.vo.BlogUserVo;

@Service
public class BlogUserService {
	@Autowired
	private BlogUserDao dao;
	
	public void join( BlogUserVo blogUserVo ) {
		dao.insert(blogUserVo);
	}
	
	public void modifyUser( BlogUserVo blogUserVo ) {
		dao.update(blogUserVo);
	}
	
	public BlogUserVo getUser( Long userNo ) {
		return dao.get(userNo);
	}
	
	//Controller가 할 
	public BlogUserVo login( BlogUserVo blogUserVo ) {
		BlogUserVo authUser = dao.get(blogUserVo);
		return authUser;
	}
	
	public BlogUserVo getUser( BlogUserVo blogUserVo ) {
		return dao.get(blogUserVo);
	}
	
	public BlogUserVo getUser( String userName ) {
		return dao.get(userName);
	}
	
}
