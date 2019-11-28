<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/board/update" method="POST">
	<input type="hidden" name="_method" value="put" />
		<input type="hidden" name="id" value="${board.id}" />
		<table>

			<tr>
				<td>Title</td>
				<td><input type="text" name="title" value="${board.title}"/></td>
			</tr>
			<tr>
				<td>Content</td>
				<td><textarea rows="5" cols="40" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>