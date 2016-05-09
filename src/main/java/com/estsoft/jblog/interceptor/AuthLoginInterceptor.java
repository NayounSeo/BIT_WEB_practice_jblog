package com.estsoft.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.estsoft.jblog.service.BlogUserService;
import com.estsoft.jblog.vo.BlogUserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	BlogUserService blogUserService;
	
	@Valid
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		BlogUserVo blogUserVo = new BlogUserVo( );
		blogUserVo.setUserName(userName);
		blogUserVo.setPassword(password);
		
		// Login Service 호출 ( 로그인 작업 )
		BlogUserVo authUser = blogUserService.login( blogUserVo );
		
		if ( authUser == null ) {
			response.sendRedirect( request.getContextPath( ) + "/user/login");
			return false;
		}
		
		// Login 처리
		HttpSession session = request.getSession( true );
		session.setAttribute("authUser", authUser);
		response.sendRedirect( request.getContextPath( )+"/main" );
		
		return false;
	}
}
