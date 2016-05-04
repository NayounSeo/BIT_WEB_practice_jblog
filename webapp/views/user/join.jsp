<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
<c:import url="/views/include/headeruser.jsp"/>
	<div class="center-content">
		<form class="join-form" id="join-form" method='POST' action='${pageContext.request.contextPath}/user/join'>
			<label class="block-label" for="userName">별명</label>
			<input id="userName" name="userName" type="text"> 
				<spring:hasBindErrors name="BlogUserVo">
				   <c:if test="${errors.hasFieldErrors('userName') }">
				        <br>
				        <strong style="color: red"> ${errors.getFieldError( 'userName' ) }<br>
						<c:set var="errorUserName" value="${errors.getFieldError( 'userName' ).codes[0] }" />
						<spring:message code="${errorUserName }" text="${errors.getFieldError( 'userName' ).defaultMessage }" /> 
					</strong>
				   </c:if>
				</spring:hasBindErrors>
			
			<input id="btn-checkemail" type="button" value="id 중복체크">
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">비밀 암호</label>
			<input id="password" name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>
</body>
</html>
