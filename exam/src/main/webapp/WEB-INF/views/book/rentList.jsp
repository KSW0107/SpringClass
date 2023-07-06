<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여현황조회</title>
<style>
    .no{text-align: center;}
    .text{ text-align: left;}
    .number {text-align: right;}
    th { text-align: center;}
    table, tr, td, th { border:1px solid;}
</style>
</head>
<body>
	<table>
        <thead>
            <tr>
                <th>도서번호</th>
                <th>도서명</th>
                <th>대여총계</th>
                <th>대여횟수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${rentList}" var="rent">
            	<tr>
                    <td class="no">${rent.bookNo}</td>
                    <td class="text">${rent.bookName}</td>
                    <td class="number">${rent.rentTotalPrice}</td>
                    <td class="number">${rent.rentCount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>