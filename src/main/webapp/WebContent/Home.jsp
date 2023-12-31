<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="Public/Img/logo_v3_rb.png">
<link rel="styleSheet" href="Style/HomeStyle.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>Suvvy Edu - Flash Card</title>
</head>
<body>
		<%@include file="Share/Header.jsp" %>
	<!-- Banner -->
	<div
		class="Page1 w-100 vh-100 d-flex justify-content-center align-items-center">
		<div class="content text-center">

			<div class="TextMain">
				<p class=" fw-bold " style="padding-right: 5px ">Hello,</p>
				<p class="fw-bold" style="color: #9B4819 ">Wellcome to
					Suvvy!</p>
			</div>
			<div class="DetailMain">
				<i>
					<p>Chúng tôi thực sự tin rằng đây là nơi có thể giúp bạn cải
						thiện</p>
					<p>khả năng sử dụng và vốn từ vựng của mình</p>
				</i>
			</div>
			<div class="Hire">
				<a href="LoginController" style = "color: #9B4819"> <i>Hire Me</i></a>
			</div>
		</div>
	</div>
	<!-- Main content -->
	<div class="container my-5 d-grid gap5 w-100 ">
		<div id="Page2">
			<div class="row1" >
				<h2>About Suvvy!</h2>
			</div>
			<br>
			<br><br><br>
			<div class="row2 d-flex ">
				<div class="SubAbout col d-flex flex-column align-items-center">
					<img alt="kienthuc" src="Public/Img/KienThuc_rb.png">
					<h4>Kiến thức</h4>
					<span>Cá nhân hóa nội dung</span> <br>
					<p>Nội dung bài học do bạn quyết định </p>
				</div>
				<div class="SubAbout col d-flex flex-column align-items-center">
					<img alt="kienthuc" src="Public/Img/PhuongPhap_rb.png">
					 <h4>Phương pháp</h4>
					<span >Spaced Repetition</span><br>
					<p>Giúp bạn học tập hiệu quả</p>
				</div>
				<div class="SubAbout col d-flex flex-column align-items-center">
					<img alt="kienthuc" src="Public/Img/UngDung_rb.png">
					 <h4>Ứng dụng</h4>
					<span>Áp dụng</span><br>
					<p>Tự tin áp dụng vào đời sống, công việc</p>
				</div>
			</div>
		</div>
	</div>
	<%@include file="Share/Footer.jsp" %>
	<script src="Style/bootstrap-5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>