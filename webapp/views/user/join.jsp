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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript">
	$(function() {
		// form id는 여기에 쓰는 거였구나~~
		$("#join-form").submit(function() {
			//2016 04 18 오늘의 과제
			//1. 이름 유효성 체크 - @Valid로 체크
			//3. 약관 체크 유무
			if ($("#agree-prov").is(":checked") == false) {
				alert("약관 동의에 체크해주세요.");
				return false;
			}
			//4. 패스워드 유효성 체크  - @Valid로 체크
			return true;
		});

		$("#userName").change(function() {
			$("#btn-checkuserName").show();
			$("#img-checkuserName").hide();
		});

		$("#btn-checkuserName")
			.click(
				function() {
					var name = $("#userName").val();
					if ( name == "") {
						return;
					}
					$.ajax({
						url : "${pageContext.request.contextPath}/user/checkname?name="+ name, 
						type : "GET", //통신방식 GET
						dataType : "json",
						data : "",
						success : function(response) { //성공시 callback
							if (response.result != "success") {
								return;
							}
							if (response.data == false) {
								$(function() {
								    $( "#dialog" ).dialog();
								  });
								$("#userName").val("").focus();
								return;
							}
							//여기서부터는 사용 가능한 이메일
							$("#btn-checkuserName").hide();
							$("#img-checkuserName" ).show();
						},
						error : function(jqXHR, status, error) { //실패시 callback
							console.error(status + ":" + error);
						}
					});
				});
	});
</script>
</head>
<body>
<c:import url="/views/include/headeruser.jsp"/>
	<div class="center-content">
		<form class="join-form" id="join-form" method='POST' action='${pageContext.request.contextPath}/user/join'>
			<label class="block-label" for="userName">별명</label>
			<input id="userName" name="userName" type="text"><br>
			<spring:hasBindErrors name="blogUserVo">
			   <c:if test="${errors.hasFieldErrors('userName') }">
			         <strong style="color: red">${errors.getFieldError( 'userName' ).defaultMessage }</strong>
			   </c:if>
			</spring:hasBindErrors>

			<input id="btn-checkuserName" type="button" value="별명이 중복인가요?">
			<img id="img-checkuserName" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">비밀 암호</label>
			<input id="password" name="password" type="password" /><br>
			<spring:hasBindErrors name="blogUserVo">
			   <c:if test="${errors.hasFieldErrors('password') }">
			         <strong style="color: red">${errors.getFieldError( 'password' ).defaultMessage }</strong>
			   </c:if>
			</spring:hasBindErrors>


			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>
			<input type="submit" value="가입하기">
		</form>
	</div>
	<div id="dialog" title="이미 존재하는 별명이에요.">
		<p style='margin-top:20px'>다른 거 써라.</p>
	</div>
</body>
</html>
