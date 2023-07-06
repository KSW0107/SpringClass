<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 조회</h1>
<a href="deptInsert">등록</a>
<table>
	<thead>
		<tr>
			<th><input type="checkbox"/></th>
			<th>부서번호</th>
			<th>부서명</th>
			<th>매니저번호</th>
			<th>지역번호</th>
			<th>수정</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${deptList }" var="dept">
		<tr>
			<td><input type="checkbox"/></td>
			<td>${dept.departmentId }</td>
			<td>${dept.departmentName }</td>
			<td>${dept.managerId }</td>
			<td>${dept.locationId }</td>
			<td><button>수정</button></td>		
		</tr>
		</c:forEach>
		<tr>
			<td><button>삭제</button></td>
		</tr>
	</tbody>
</table>

<script>
	
</script>
</body>
</html>