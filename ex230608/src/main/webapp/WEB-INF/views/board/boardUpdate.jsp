<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>

<body>
	<form name="updateForm" onsubmit="return false">
		<!-- submit 차단 -->
		<div>
			<h3>게시글 수정</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${board.bno}"
					readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${board.writer }"
					readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${board.contents }</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name="image" value="${board.image }"></td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<!-- input 태그가 Date 형식만 인식하기 때문에 데이트 형식으로 변환시켜줌 -->
				<td><input type="date" name="updatedate"
					value='<fmt:formatDate value="${board.updatedate}" type="date" pattern="yyyy-MM-dd"/>'></td>
			</tr>
		</table>
		<button type="submit" id="updateBtn">수정완료</button>
		<button type="button" onclick="location.href='boardList'">취소</button>

	</form>
	<script>
		document.querySelector('#updateBtn').addEventListener('click', function () {

			// form의 데이터를 한번에 가져오는 형식 (formData 데이터 형식은 multipart 의존성,bean 등록 필요)
			let boardData = new FormData(document.querySelector("[name='updateForm']"))

			/*let data = {
				'bno' : updateForm.bno.value,
				'title' : updateForm.title.value,
				'writer' : updateForm.writer.value,
				'contents' : updateForm.contents.value,
				'image' : updateForm.image.value,
				'updatedate' : updateForm.updatedate.value,
			}*/

			fetch('boardUpdate', {
					method: "POST",
					body: boardData
				})
				.then(response => response.json())
				.then(result => {
					if (result.result) {
						alert(result.board_no + "번 게시글 수정 완료")
					} else {
						alert("수정실패")
					}
					location.href="boardList"
				})
				.catch(err => console.log(err))
		})
	</script>
</body>

</html>