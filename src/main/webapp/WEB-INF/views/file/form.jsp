<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>

	<form action="/file/save" method="post" enctype="multipart/form-data">
		<select id="dir">
			<option value="/">/
			<option value="/images">이미지
			<option value="/data">자료
			<option value="/general">공통
		</select> 
		<input type="file" name="file"> 
		<input type="submit" name="저장"> 
		<input type="reset" name="취소">
	</form>

</body>
</html>