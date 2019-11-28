<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/board/write" method="POST">

		<table>

			<tr>
				<td>Title</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Content</td>
				<td><textarea rows="5" cols="40" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>