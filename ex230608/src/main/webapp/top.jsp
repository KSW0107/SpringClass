<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- csrf에 필요한 토큰 정보 추가 (방법1) -->
<sec:csrfMetaTags />
<title>Insert title here</title>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
			<!-- 특정 권한일때만 페이지에 보이게 -->
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	
		</ul>

	<!-- 인증이 됐을 경우에만 페이지에 보이게 -->
	<sec:authorize access="isAuthenticated()">
		<form action="logout" method="post">
			<!-- csrf에 필요한 토큰 정보 추가 (방법2) -->
			<!-- form태그는 알아서 토큰 정보를 header에 담지만 fetch, ajax는 직접 명시해주거나 상위의 meta 태그를 명시해야함 -->
			<sec:csrfInput />
			<button>로그아웃</button>
		</form>
	</sec:authorize>
	
	<!-- sec 태그 사용없이 토큰 정보 넘기는 법 -->
	<input type="hidden" name="csrf_name" value="${_csrf.parameterName } ">
	<input type="hidden" name="csrf_val" value="${_csrf.token } ">
</body>
</html>