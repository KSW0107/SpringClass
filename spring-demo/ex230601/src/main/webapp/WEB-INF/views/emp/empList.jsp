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
	<h2>사원 조회</h2>
	<a href="empInsert">등록</a>
	<form action="empList" method="get">
		<label>부서</label><input name="departmentId" value="${emp.departmentId }">
		<label>이름</label><input name="firstName" value="${emp.firstName }">
		<br>
		<button type="submit">검색</button>
		<button id="reset" type="reset">초기화</button>
	</form>
	<table border='1'>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>성</th>
				<th>부서</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList }" var="emp">
			<tr>
				<td>${emp.employeeId }</td>
				<td>${emp.firstName }</td>
				<td>${emp.lastName }</td>
				<td>${emp.departmentId }</td>
				<td><a href="empUpdate?empId=${emp.employeeId }"><button>수정</button></a></td>
				<td><a href="empDelete?empId=${emp.employeeId}"><button>삭제</button></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		document.querySelector('#reset').addEventListener('click',function(){
			location.href = "empList";
		});
	</script>
</body>
</html>