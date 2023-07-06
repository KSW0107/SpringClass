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
<h3>사원 수정</h3>
<form action="empUpdate" method="post" name="frm">
	<table>
		<tr>
			<th>사번</th><td><input type="text" name="employeeId" value="${emp.employeeId }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>이름</th><td><input type="text" name="firstName" value="${emp.firstName }"></td>
		</tr>
		<tr>
			<th>성</th><td><input type="text" name="lastName" value="${emp.lastName }"></td>
		</tr>
		<tr>
			<th>이메일</th><td><input type="text" name="email" value="${emp.email }"></td>
		</tr>
		<tr>
			<th>입사일</th><td><input type="text" name="hireDate" value="${emp.hireDate }"></td>
		</tr>
		<tr>
			<th>부서</th>
			<td>
				<c:forEach items="${depts }" var="dept"  varStatus="status">
				<span style="width:100px"><input type="radio" name="departmentId" value="${dept.departmentId }" <c:if test="${dept.departmentId==emp.departmentId }">checked</c:if>>${dept.departmentName }</span>
				<c:if test="${status.count %3 ==0}">
					<br>
				</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>직무</th>
			
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
	</table>
</form>

<script>
	frm.jobId.value="${emp.jobId}"
</script>
</body>
</html>