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
<h3>부서등록</h3>
<form action="deptInsert" method="post">
<table>
	<tbody>
		<tr>
			<td>부서명</td><td><input name="departmentName"/></td>
		</tr>
		<tr>
			<td>매니저</td>
			<td>
				<c:forEach items="${managers }" var="manager"  varStatus="status">
				<span style="width:100px"><input type="radio" name="managerId" value="${manager.employeeId }">${manager.firstName }_${manager.lastName }</span>
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
	</tbody>
</table>
</form>
</body>
</html>