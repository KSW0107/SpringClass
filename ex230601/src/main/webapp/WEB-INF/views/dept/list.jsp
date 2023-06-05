<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 부서 정보</title>
</head>
<body>
<div>
	<h3>부서조회</h3>
	<a href="deptInsert">등록</a>
	<button type="button" id="checkDel">선택삭제</button>
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>지역번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptList}" var="dept">
				<!-- <tr onclick="location.href='deptInfo?departmentId=${dept.departmentId }'"> -->
				<!-- button 클릭시 td 이벤트 막기 -->
				<tr onclick="findDeptInfo(event, ${dept.departmentId})">
					<td><input type="checkbox"></td>
					<td>${dept.departmentId }</td>
					<td>${dept.departmentName }</td>
					<td>${dept.managerId }</td>
					<td>${dept.locationId }</td>
					<td><button type="button" class="delOneDept">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	<form name="del" action="deptDelete" method="POST">
	</form>
</div>
<script>
	let result  ="${departmentId}";
	if(result != "") {
		alert(result);
	}
	
	//선택 삭제 클릭 시 실행
	document.getElementById('checkDel').addEventListener('click', function(e){
		let checked = document.querySelectorAll('input[type="checkbox"]:checked')

		for(let i=0; i<checked.length; i++){
			let deptNo = checked[i].parentElement.nextElementSibling.textContent;
			insertDeptInfo(i, deptNo)
		}

		del.submit();
	});

	//del form 에 input 넣기
	function insertDeptInfo(index, deptNo){
		let inputTag = document.createElement('input');
		inputTag.type='hidden';
		inputTag.name = 'deptList['+index+'].departmentId';
		inputTag.value = deptNo;

		let formTag = document.getElementsByName('del')[0];
		formTag.append(inputTag);
	}

	let delBtn = document.querySelectorAll('.delOneDept')
	delBtn.forEach(btn => {
		btn.addEventListener('click', function(e){
			let tdList = this.parentElement.parentElement.children;
			let deptNo = tdList[1].textContent;
			insertDeptInfo(0, deptNo)
			del.submit();
		})
	});

	function findDeptInfo(event, deptNo){
		if(event.target.tagName != 'INPUT' && event.target.tagName != 'BUTTON'){
			location.href='deptInfo?departmentId='+deptNo;

			/*
			event.target // 실제 이벤트가 발생한 태그 : 고정값
			event.currentTarget // this 와 같은 의미 -> 지금 해당 이벤트에 대해 동작을 하는 태그
			event.preventDefault(); // 기본으로 등록된 이벤트 동작을 막음
			event.stopPropagatoin(); //이벤트 버블링(부모요소로의 전파)를 막음
			*/
		}
	}
</script>
</body>
</html>