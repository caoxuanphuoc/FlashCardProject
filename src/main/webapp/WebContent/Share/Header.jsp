<%@page import="Bean.Dto.UserLoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/b220baa0bb.js" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark">
		<div class="container-fluid">
			<div class="HomeTitle d-flex ms-5">
				<img alt="logo"  src="Public/Img/logo_v3_rb.png">
				 <a id="tiH" class="navbar-brand fs-2 fw-bold pl-5 text-white" href="#">Suvvy
					Edu</a>
			</div>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div id="colap" class="collapse navbar-collapse fs-4" id="navbarNav">
				<div class="mx-auto"></div>
				<ul class="navbar-nav ">
					<li class="nav-item"><a class="nav-link "  style="color: black" href="#">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link " style="color: black"href="#Page2">About</a>
					</li>
					<li class="nav-item"><a class="nav-link " style="color: black" href="#footer">Contact</a>
					</li>
					<%
					UserLoginDto infoUserLogin = (UserLoginDto) session.getAttribute("InfoUserLogin");
					if(infoUserLogin == null){  %>
					<li class="nav-item"><a class="nav-link text-black" href="LoginController">
					<button class = "btn btn-outline-success" >
						Login
					</button>
					</a>
					</li>
					<%}else{%>
					<li class="nav-item"><a class="nav-link text-black" href="LoginController">
						<i class='fas fa-user-tie' style='font-size:30px ; color: #9B4819'></i>
					</a>
					</li>
					<%} %>
				</ul>
			</div>
		</div>
	</nav>
	<script src="Style/bootstrap-5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		var nav = document.querySelector('nav');
		var ti = document.getElementById("tiH");
		var mn = document.getElementById("colap");
		window.addEventListener('scroll', function() {
			if (window.pageYOffset > 450) {
				ti.classList.remove('fs-2')
				ti.classList.add('fs-4')
				mn.classList.remove('fs-4')
				mn.classList.add('fs-5')
				nav.classList.add('bg-nav', 'fs-3' ,'shadow');
			} else {
				ti.classList.add('fs-2')
				ti.classList.remove('fs-4')
				mn.classList.remove('fs-5')
				mn.classList.add('fs-4')
				nav.classList.remove('bg-nav', 'shadow');
			}
		});
	</script>
</body>
</html>