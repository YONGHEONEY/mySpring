<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<title>File Home</title>
</head>
<body>
<h1>
	안녕하세요. 저장소 입니다. 오늘도 좋은 하루 되세요.
</h1>

<p><a href="/file/new">파일 업로드</a></p>
<p><a href="/file/list">파일 전체 목록</a></p>
<form action="" name=form>

디렉토리 목록 : <select id="dir">
<option value="/">/
<option value="/images">이미지
<option value="/data">자료
<option value="/general">공통
</select><br>
<input type=submit value="조회" id="form">
</form>
<br><br>
<form action="">
파일 번호 검색 : <input type="text" name="fileId"> <input type="submit" value="검색">
</form>

<script>
$(document).ready(function() {
	$("#form").click(function() {
		var dir = $("#dir option:selected").val();
		document.form.action="/file/list"+dir;
	})
})
</script>

</body>
</html>
