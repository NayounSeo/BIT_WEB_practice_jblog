<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%><!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
<c:import url="/views/include/headeruser.jsp"/>
	<div class="center-content">
		<form class="login-form" method="post" action="${pageContext.request.contextPath}/user/login">
      		<br><strong style='color:red'>${interceptorMessage == null}떠라 떠</strong><br>
      		<label>별명</label> <input type="text" name="userName">
      		<spring:hasBindErrors name="blogUserVo">
			   <c:if test="${errors.hasFieldErrors('userName') }">
			         <strong style="color: red">${errors.getFieldError( 'userName' ).defaultMessage }</strong>
			   </c:if>
			</spring:hasBindErrors>
      		<label>비밀 암호</label> <input type='password' name="password">
      		<spring:hasBindErrors name="blogUserVo">
			   <c:if test="${errors.hasFieldErrors('password') }">
			         <strong style="color: red">${errors.getFieldError( 'password' ).defaultMessage }</strong>
			   </c:if>
			</spring:hasBindErrors>
      		<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>
