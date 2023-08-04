<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="../../Style/bootstrap-5.0.2/dist/css/bootstrap.min.css">
<link rel="styleSheet" href="../../Style/BaseStyle.css">
</head>
<body>
<div class="pt-3 offset-md-2 d-flex" >
			<a href="HomeController" style="width:50px; height:50px">
				<img alt="logo" src="Public/Img/logo_v3_rb.png" style="width:100%; height:100%">
			</a>
					<h1 class=" ps-3" style="color: #9B4819">Đăng ký</h1>
			</div>
<div class="col-8 border border-success mt-4 ps-6 p-5 rounded-3 d-flex justify-content-center
			 position-absolute start-50 translate-middle-x shadow p-3 mb-5 bg-body rounded">
				<form class="col-10">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">
						<b>Email address</b> </label> <input type="email" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
						<div id="emailHelp" class="form-text">We'll never share your
							email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label"><b> Password</b></label>
						<input type="password" class="form-control"
							id="exampleInputPassword1">
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label"><b> Confirm Password</b></label>
						<input type="password" class="form-control"
							id="exampleInputPassword1">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Remember me</label>
					</div>
					<div class="d-flex justify-content-center pt-2">
				<button class="btn btn-outline-success " >Đăng Ký</button>
					</div>
				</form>

			</div>
</body>
</html>