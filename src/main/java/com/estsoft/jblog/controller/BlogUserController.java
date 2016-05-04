package com.estsoft.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estsoft.jblog.service.BlogUserService;
import com.estsoft.jblog.vo.BlogUserVo;

@Controller
@RequestMapping("/user")
public class BlogUserController {
	@Autowired
	private BlogUserService blogUserService;
	
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
		     /* 에러 출력 구현*/
			System.out.println("가입 에러났대");
			System.out.println(result);
			
			model.addAllAttributes( result.getModel( ) );
			return "/user/join";
		}
		blogUserService.join(blogUserVo);
		return "user/joinsuccess";
	}

}
