<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/user/join" method="post">
		<table>
			<tr>
				<th>Username</th>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type=email " name="email" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<th>Phone</th>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입완료" />
			</tr>
		</table>
	</form>
</body>
</html>