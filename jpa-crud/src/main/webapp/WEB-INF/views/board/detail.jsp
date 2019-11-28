<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<table>
		<tr>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>

		<tr>
			<td>${board.title}</td>
			<td>${board.content}</td>
			<td>${board.user.username}</td>
			<td>${board.createDate}</td>

		</tr>
	</table>

	<button onClick="location.href='/board/updateForm/${board.id}'">수정하기</button>
	<form action="/board/delete/${board.id}" method="post">
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">삭제하기</button>
	</form>



</body>
</html>