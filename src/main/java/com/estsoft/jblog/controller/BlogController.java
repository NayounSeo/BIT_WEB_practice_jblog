package com.estsoft.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.jblog.annotation.Auth;
import com.estsoft.jblog.service.BlogService;
import com.estsoft.jblog.service.CategoryService;
import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping( "/main/{userName}")
	public String main( @PathVariable("userName") String userName, Model model) {
		BlogVo blogVo = blogService.getBlog(userName);
		System.out.println("blogController에서의 "+blogVo);
		System.out.println("blogController에서의 블로그 번호는 "+blogVo.getBlogNo( ));
		List<CategoryVo> categoryList = categoryService.showCategoryList(blogVo.getBlogNo( ));
		for (CategoryVo vo : categoryList) {
			System.out.println(vo);
		}
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		return "blog/blog-main";
	}
	
	@Auth
	@RequestMapping("/adminbasic/{userNo}")
	public String adminbasic(@PathVariable("userNo") long userNo, Model model) {
		BlogVo blogVo = blogService.getBlogByUserNo(userNo);
		System.out.println("/adminbasic에서의 blogVo "+blogVo);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-basic";
	}
	
	//왜 logoImage는 안넘어가는걸까....? default인지 아닌지도 나중에 확인하기 TODO
	//RequestParam 받는데 내가 뭔가를 까먹고 있나?
	@RequestMapping(value="/modifyblog", method=RequestMethod.POST)
	public String modifyBlog(@ModelAttribute BlogVo blogVo, @RequestParam(value="logoImage", required=true, defaultValue="/assets/images/spring-logo.jpg") String logoImage) {
		blogVo.setLogoImage(logoImage);
		blogService.modifyBlog(blogVo);
		blogVo = blogService.getBlogByBlogNo(blogVo.getBlogNo( ));
		System.out.println("뭐야 왜 되던게 안돼 "+blogVo);
		return "redirect:/blog/main/"+blogVo.getUserName( );
	}
	
	@RequestMapping("/managecategory/{blogNo}")
	public String manageCategory(@PathVariable("blogNo") long blogNo, Model model ) {
		BlogVo blogVo = blogService.getBlogByBlogNo(blogNo);
		List<CategoryVo> categoryList = categoryService.showCategoryList(blogVo.getBlogNo( ));
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping("/writepost/{blogNo}")
	public String writePost(@PathVariable("blogNo") long blogNo, Model model ) {
		System.out.println("managecategory에서의 "+blogNo+" 뭐야 뭐 바꾼 것도 없는데 model에 넣기만 하니까 갑자기 돼 이 뭐 ");
		BlogVo blogVo = blogService.getBlogByBlogNo(blogNo);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-write";
	}
	
}
