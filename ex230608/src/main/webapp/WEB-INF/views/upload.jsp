<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>

<body>
	<div>
		<input name="uploadFiles" type="file" multiple>
		<button class="uploadBtn">Upload</button>
	</div>
	<script>
		$('.uploadBtn').click(function () {
			var formData = new FormData(); //FormData 객체 생성

			var inputFile = $("input[type='file']")
			//input 태그의 type이 file인 것을 찯아서 inputFile 이라는 변수로 지정

			var files = inputFile[0].files;
			//files : 선택한 모든 파일을 나열하는 FileList 객체입니다
			//multiple 특성을 지정하지 않았다면 두 개 이상의 파일을 포함하지 않습니다

			for (var i = 0; i < files.length; i++) {
				console.log(files[i]);
				formData.append("uploadFiles", files[i]); //키,값으로 append
			}

			//실제 업로드 부분 
			//fetch
			/* fetch('uploadsAjax', {
					method: 'POST',
					body: formData
				})
				.then(response => response.text())
				.then(data => console.log(data))
				.catch(err => console.log(err)) */

			//jquery.ajax
			$.ajax({
				url: 'uploadsAjax',
				type: 'POST',
				processData: false, // 기본값은 true, ajax 통신을 통해 데이터를 전송할때, 기본적으로 key와 value 값을 Query String으로 변환해서 보내줌
				contentType: false, // multipart/form-data 타입을 사용하기위해 false로 지정
				data: formData,
				success: function (result) {
					console.log(result)
				},
				error: function (reject) {
					console.log(reject)
				}
			})

		})
	</script>
</body>

</html>