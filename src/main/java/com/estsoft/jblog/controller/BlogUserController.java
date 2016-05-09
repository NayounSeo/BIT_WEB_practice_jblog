package com.estsoft.jblog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estsoft.jblog.service.BlogService;
import com.estsoft.jblog.service.BlogUserService;
import com.estsoft.jblog.service.CategoryService;
import com.estsoft.jblog.vo.BlogUserVo;
import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/user")
public class BlogUserController {
	@Autowired
	private BlogUserService blogUserService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/loginform")
	public String loginform( ) {
		//실제의 login은 AuthLoginInterceptor에서 path를 받아 처리해줍니다.
		//logout도 마찬가지로 AuthLogoutInterceptor에서
		return "user/login";
	}
	
	@RequestMapping("/joinform")
	public String joinform( ) {
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute @Valid BlogUserVo blogUserVo, BindingResult result, Model model ) {
		if ( result.hasErrors( ) ) {
			System.out.println(result);
			
			model.addAttribute("errorMessageFromController", "가입 에러입니다.");
			model.addAllAttributes( result.getModel( ) );
			return "/user/join";
		}
		blogUserService.join(blogUserVo);
		System.out.println(blogUserVo.getUserNo( ));
		
		//가입시 블로그 생성.
		BlogVo blogVo = new BlogVo( blogUserVo );
		//이건 DB에 넣어주는 작업.
		blogService.createBlog(blogVo);
		//카테고리에 대해서도.
        CategoryVo categoryVo = new CategoryVo(blogVo.getBlogNo( ));
        categoryService.createCategory(categoryVo);
		
		return "user/joinsuccess";
	}

	@RequestMapping("/checkname")
	@ResponseBody
	public Object checkName(@RequestParam(value = "name", required = true, defaultValue = "") String userName) {
		BlogUserVo vo = blogUserService.getUser(userName);
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("/chechname에서의 vo 정보 "+ vo);
		map.put("result", "success");
		map.put("data", vo == null);
		return map;
	}
	
}
