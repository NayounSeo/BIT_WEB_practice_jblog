<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
<c:import url="/views/include/headerblog.jsp"/>
	<div id="container">
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected">기본설정</li>
					<li><a href="${pageContext.request.contextPath}/blog/managecategory/${blogVo.blogNo }">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/writepost/${blogVo.blogNo }">글작성</a></li>
				</ul>
				<form action='${pageContext.request.contextPath}/blog/modifyblog' method='POST'>
				<!--  아니.. 이분은 왜 안넘어간대요?ㅜㅠㅜ -->
				<input type='hidden' id='blogNo' name="blogNo" value="${blogVo.blogNo }">
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" id='title' name="title" value='${blogVo.title }'></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
			      			<td><img name="logoImage" src="${pageContext.request.contextPath}${blogVo.logoImage }"></td>      			
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" name="logo-file"></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
				</form>
			</div>
		</div>
		<c:import url="/views/include/footerblog.jsp"/>
	</div>
</body>
</html>