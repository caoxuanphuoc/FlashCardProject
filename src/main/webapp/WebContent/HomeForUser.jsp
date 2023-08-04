<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="Style/bootstrap-5.0.2/dist/css/bootstrap.min.css">
<link rel="styleSheet" href="Style/BaseStyle.css">
</head>
<body>
	<%@include file="Share/HeaderForLogged.jsp"%>
	<!-- Vùng chứa nội dung -->
	<div class="container-fluid"
		style="padding-top: 5%; background-color: #f6f7fb; height: 1000px">
		<div class="content ms-5">
			<!-- Hàng thứ nhất -->
			<div class="row ">
				<div class="col-9">
					<div class="row pt-3 ">
						<h4 class="pb-2">Gần đây</h4>
					</div>
					<div class="row ">
						<%
						for (int i = 0; i < 3; i++) {
						%>
						<div class="col-sm-4 ">
							<a href="https://getbootstrap.com/docs/5.0/migration/#sass"
								class="text-decoration-none text-black">
								<div class="card shadow-sm p-2 mb-3 bg-body rounded"
									style="border-radius: 20px !important">
									<div class="card-body p-3">
										<h5 class="card-title">Reading</h5>
										<p class="card-text mb-5 mt-2">22 thuật ngữ</p>
										<span class="mt-4">infomation </span>
									</div>
								</div>
							</a>
						</div>
						<%
						}
						%>
					</div>

				</div>
				<!-- Thẻ 2 -->
				<div class="col-9">
					<div class="row ">
						<div class="col-sm-12">
							<div class="card shadow-sm p-2 mb-5 bg-body rounded"
								style="border-radius: 20px !important">
								<div class="card-body row d-flex justify-content-between">
									<!-- Số lượng đã học -->
									<div class="card col-sm-3 shadow-sm p-2 rounded text-white"
										style="border-radius: 20px !important; background-color: #ff5139">
										<div class="card-body">
											<i class='far fa-chart-bar' style='font-size: 40px'></i>
											<h4 class="pt-2">Số lượng</h4>
											<span style="font-size: 50px; font-weight: normal;">1200</span>
										</div>
									</div>
									<!-- Ngày học liên tiếp -->
									<div class="card col-sm-3 shadow-sm p-2 rounded text-white"
										style="border-radius: 20px !important; background-color: #314028">
										<div class="card-body">
											<i class='fas fa-chart-line' style='font-size: 40px'></i>
											<h4 class="pt-2">Ngày học</h4>
											<span style="font-size: 50px; font-weight: normal;">1200</span>
										</div>
									</div>
									<!-- SÔ người theo dõi -->
									<div class="card col-sm-3 shadow-sm p-2 rounded text-white"
										style="border-radius: 20px !important; background-color: #9b4819">
										<div class="card-body">
											<i class='fas fa-sitemap' style='font-size: 40px'></i>
											<h4 class="pt-2">Theo dõi</h4>
											<span style="font-size: 50px; font-weight: normal;">1200</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Hàng thứ nhất -->
			<!-- Hàng thứ hight -->
			<div class="row">
				<div class="col-12">
					<h4>Bộ sưu tập thịnh hành</h4>
					<div class="row pt-4">
						<%
						for (int i = 0; i < 3; i++) {
						%>
						<div class="col-sm-3 ">
							<a href="https://getbootstrap.com/docs/5.0/migration/#sass"
								class="text-decoration-none text-black">
								<div class="card shadow-sm p-2 mb-3 bg-body rounded"
									style="border-radius: 20px !important">
									<div class="card-body p-3">
										<h5 class="card-title">Reading</h5>
										<p class="card-text mb-5 mt-2">22 thuật ngữ</p>
										<span class="mt-4">infomation </span>
									</div>
								</div>
							</a>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>

		</div>
	</div>
	<%@include file="Share/Footer.jsp"%>  
</body>
</html>