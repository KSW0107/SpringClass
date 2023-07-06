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
<h3>부서 수정</h3>
<form action="deptUpdate" method="post" name="frm">
	<table>
		<tr>
			<th>부서번호</th><td><input type="text" name="departmentId" value="${dept.departmentId }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>부서명</td><td><input name="departmentName" value="${dept.departmentName }"/></td>
		</tr>
		<tr>
			<td>매니저</td>
			<td>
				<c:forEach items="${managers }" var="manager"  varStatus="status">
				<span style="width:100px"><input type="radio" name="managerId" value="${manager.employeeId }" <c:if test="${dept.managerId==manager.employeeId }">checked</c:if>>${manager.firstName }_${manager.lastName }</span>
				<c:if test="${status.count %3 ==0}">
					<br>
				</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>지역</td>
			
			<td>
				<select name="locationId">
					<option value="">----------------선택----------------</option>
					<c:forEach items="${locations }" var="location">
					<option value="${location.locationId}">${location.city}</option>
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
	frm.locationId.value="${dept.locationId}"
</script>
</body>
</html>