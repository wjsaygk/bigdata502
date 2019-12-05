<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>



<head>
  <title>전용하 블로그</title>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=euc-kr" /> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content=""> 



  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
  <a href="javascript:alert('힘내세용')" >빅데이터 3회차 화이팅</a>


      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
    
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
       
          <li class="nav-item">
            <a class="nav-link" href="/home/list">홈</a>
        <   </li>
          <li class="nav-item">
            <a class="nav-link" href="/home/post">글쓰기</a>
          </li>
         <!--  <li class="nav-item">
            <a class="nav-link" href="/user/joinForm">회원가입</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/user/loginForm">로그인</a>
          </li>   -->
          <c:choose>
								<c:when test="${empty sessionScope.user}">
								    <li class="nav-item"><a class="nav-link" href="/user/joinForm">회원가입</a></li>
									<li class="nav-item"><a class="nav-link" href="/user/loginForm">로그인</a></li>
								</c:when>
								<c:otherwise>
									<li class="nav-item"><a class="nav-link" href="/blog/user/update.jsp">Profile</a></li>
									<li class="nav-item"><a class="nav-link" href="/user/logout">Logout</a></li>
								</c:otherwise>
							</c:choose>
       
        <!--    <li class="nav-item">
            <a class="nav-link" href="/user/loginForm">로그아웃</a>
          </li> -->

        </ul>
      </div>
    </div>
  </nav>
  	
  
  
  <!-- Page Header -->
  <header class="masthead" style="background-image: url('/resources/img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>사리 블로그</h1>
            <span class="subheading">잡다한 일상</span>
          </div>
        </div>
      </div>
    </div>
  </header>
</body>

</html>
