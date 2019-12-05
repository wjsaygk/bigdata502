<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="contact_area">
	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<form class="row contact_form" action="/home/update" method="post" id="contactForm" novalidate="novalidate">
				<input type = "hidden" name = "id" value = "${post.id }"/>
					<div class="col-md-12">
						<div class="form-group">
							<input type="text" class="form-control" id="title" name="title"  value ="${post.title}" placeholder="Title">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<textarea class="form-control" name="content"  id="summernote">${post.content }</textarea>
						</div>
					</div>
					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">Posting</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<!--================Contact Area =================-->
<br />
<br />

 <div id="summernote"></div>
    <script>
      $('#summernote').summernote({
        placeholder: '글을입력하세요',
        tabsize: 2,
        height: 200
      });
    </script>
</body>
</html>