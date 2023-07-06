<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사원등록</h3>
<form action="empInsert" method="post">
<table>
	<tbody>
		<tr>
			<td>이름</td><td><input name="firstName"/></td>
		</tr>
		<tr>
			<td>성</td><td><input name="lastName"/></td>
		</tr>
		<tr>
			<td>입사일</td><td><input name="hireDate"/></td>
		</tr>
		<tr>
			<td>이메일</td><td><input name="email"/></td>
		</tr>
		<tr>
			<td>부서</td>
			<td>
				<c:forEach items="${depts }" var="dept"  varStatus="status">
				<span style="width:100px"><input type="radio" name="departmentId" value="${dept.departmentId }">${dept.departmentName }</span>
				<c:if test="${status.count %3 ==0}">
					<br>
				</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>직무</td>
			
			<td>
				<select name="jobId">
					<option value="">----------------선택----------------</option>
					<c:forEach items="${jobs }" var="job">
					<option value="${job.jobId}">${job.jobTitle}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">저장</button></td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>