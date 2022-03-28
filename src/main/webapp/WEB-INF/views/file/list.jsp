<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>File List</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>경로</th>
			<th>미리보기</th>
			<th>파일명</th>
			<th>크기</th>
			<th>유형</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>

		<c:forEach var="file" items="${fileList}">
			<c:set var="len" value="${fn:length(file.fileName)}" />
			<c:set var="fileType"
				value="${fn:toUpperCase(fn:substring(file.fileName, len-4, len))}" />

			<tr>
				<td>${file.directoryName}</td>
				<td><c:choose>
						<c:when
							test="${(fileType eq '.JPG') or (fileType eq '.JPEG') or (fileType eq '.PNG') or (fileType eq '.GIF')}">
							<img src="/file/img/${file.fileId}" width="100"
								class="img-thumbnail">
						</c:when>
						<c:otherwise>
							<img src="/resources/images/basic.jpg" width="100"
								class="img.thumbnail">
						</c:otherwise>
					</c:choose></td>

				<td><a href="/file/info/${file.fileId}">${file.fileName}</a></td>

				<td><fmt:formatNumber value="${file.fileSize/(1024*1000)}"
						pattern="#,###" />MB</td>

				<td>${file.fileContentType}</td>
				<td>${file.fileUploadDate}</td>
				<td><a href="/file/delete/${file.fileId}" class="delete">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script>
$(document).ready(function) {
	$("#delete").click(function() {
		if(confirm("이 작업은 되돌릴 수 없습니다. 파일을 정말 삭제하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
}
</script>
</body>
</html>





















