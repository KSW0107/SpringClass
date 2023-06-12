<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시글 등록</title>
</head>

<body>
	<form name="insertForm" action="boardInsert" method="POST">
		<div>
			<h3>게시글 정보</h3>
		</div>
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='boardList'">목록</button>
	</form>
	<script>
			//Form submit 차단
			document.querySelector('[name="insertForm"]').addEventListener('submit' , function(e){
				e.preventDefault(); // 해당 이벤트의 기존 실행 차단 (a 태그도 가능)

				let title = document.getElementsByName('title')[0];
				let writer = document.getElementsByName('writer')[0];
				let contents = document.getElementsByName('contents')[0];

				if(title.value == ''){
					alert("제목을 입력하시오");
					title.focus();
					return;
				}

				if(writer.value == ''){
					alert("작성자를 입력하시오");
					title.focus();
					return;
				}
				
				if(contents.value == ''){
					alert("내용을 입력하시오");
					title.focus();
					return;
				}
				
				//값이 없으면 return되기 때문에 값이 다 있어야 도달할 수 있음
				insertForm.submit()
			})
	</script>
</body>

</html>