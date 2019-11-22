<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 : ${post.title}
작성자 : ${post.userId}<br/>
내용 :  ${post.content}<br/>
<a href="/post/updateForm/${post.id}" > 수정하기</a>
<a href="/post/delete/${post.id}">삭제하기</a>

</body>
</html>