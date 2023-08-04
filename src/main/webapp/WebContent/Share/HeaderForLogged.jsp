<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/b220baa0bb.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-white position-fixed end-0 start-0 " style="z-index: 9999">
		<div class="container">
			<a id="tiH"	class="navbar-brand fw-bold ms-3" href="#" style="color: #9B4819; font-size: 24px">Suvvy
					Edu</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 col-3">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Trang chủ</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Thư viện của bạn </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
				</ul>
				<div class="d-flex justify-content-between col-7">
					<div>
						<form class="d-flex">
							<input class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search" style="width: 90%">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
					</div>
					<div>
						<ul class="navbar-nav me-auto  mb-lg-0 ">
							<li class="nav-item " ">
								<a href="#" class="hv">
									<i class="fa fa-plus-circle p-0 "
										style="color: #9B4819; font-size: 34px"></i>
								</a>
							</li>

							<li class="nav-item ms-4 hv">
							<a href="#"><i class="fa far fa-bell"
								style="color: #9B4819; font-size: 34px"></i></a>
							</li>
							
							<li class="nav-item ms-4 me-3">
							<a href="#"><i class="fa fa fa-user"
								style="color: #9B4819; font-size: 34px"></i> </a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>