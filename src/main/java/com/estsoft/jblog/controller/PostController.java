package com.estsoft.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.jblog.service.CategoryService;
import com.estsoft.jblog.service.PostService;
import com.estsoft.jblog.vo.PostVo;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/write")
	public String write(@ModelAttribute PostVo postVo, @RequestParam("userName") String userName ) {
		System.out.println("PostController write에서의 postVo "+postVo+" : "+userName);
		postService.writePost(postVo);
		categoryService.updatePostCount(postVo.getCategoryNo( ));
		return "redirect:/blog/main/"+userName;
	}

}
