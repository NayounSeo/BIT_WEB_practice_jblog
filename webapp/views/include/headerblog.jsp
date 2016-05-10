<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="container">
	<div id="header">
		<h1>${blogVo.title }</h1>
		<ul>
			<!--c:choose-->
			<c:if test='${empty authUser == true }'>
				<!-- c:when test='${empty authUser }' -->
					<li><a href='${pageContext.request.contextPath}/user/loginform'>로그인</a></li>
					<li><a href='${pageContext.request.contextPath}/user/joinform'>회원가입</a></li>
				<!--/c:when-->
			</c:if>
			<c:if test='${empty authUser != true'>
				<!--c:otherwise-->
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<c:if test='${authUser ==  blogVo.userNo  }'>
						<li><a href="${pageContext.request.contextPath}/blog/adminbasic/${authUser.userNo}">블로그 관리</a></li>
					</c:if>
				<!--/c:otherwise-->
			<!--/c:choose-->
			</c:if>
		</ul>
	</div>
</div>
