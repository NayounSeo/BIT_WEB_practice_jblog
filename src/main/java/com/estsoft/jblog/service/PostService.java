package com.estsoft.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.jblog.dao.PostDao;
import com.estsoft.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostDao dao;
	
	public void writePost( PostVo postVo ) {
		dao.insert(postVo);
	}
	
	public void deletePost( long postNo ) {
		dao.deleteOne(postNo);
	}
	
	public void deleteAllPost( long categoryNo ) {
		dao.deleteAll(categoryNo);
	}
	
	public PostVo showPost( long postNo ) {
		return dao.getByNo(postNo);
	}
	
	public List<PostVo> showPostList( long categoryNo ) {
		return dao.getByCategory(categoryNo);
	}
}
