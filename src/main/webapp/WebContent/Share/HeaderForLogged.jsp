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
	<nav
		class="navbar navbar-expand-lg navbar-light bg-white position-fixed end-0 start-0 "
		style="z-index: 9999">
		<div class="container">
			<a id="tiH" class="navbar-brand fw-bold ms-3" href="HomeForUserController"
				style="color: #9B4819; font-size: 24px">Suvvy Edu</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 col-3">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Bộ sưu tâp </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="CollectionCardController">Tất cả</a></li>
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
							<li class="nav-item "">
		<!---------------------Add-Collection----------------------------- -->
								<a href="#" class="hv" data-bs-toggle="modal"
								data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">
									<i class="fa fa-plus-circle p-0 "
									style="color: #9B4819; font-size: 34px"></i>
							</a>

								<div class="modal fade" id="exampleModal" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog pt-5">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Thêm bộ
													sưu tập</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">
												<form id="addcollect" action="CollectionCardController">
													<div class="mb-3">
														<label for="recipient-name" class="col-form-label">Tên
															bộ sưu tập:</label> <input name="NameCollect" type="text" class="form-control"
															id="recipient-name">
													</div>
													<div class="mb-3">
														<label for="message-text" class="col-form-label">Mô
															tả:</label>
														<textarea name="DiscriptCollect" class="form-control" id="message-text"></textarea>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<input form="addcollect" type="submit"
													class="btn btn-primary" value="Tạo">
											</div>
										</div>
									</div>
								</div> 
<!------------------------------------------------------->

							</li>

							<li class="nav-item ms-4 hv"><a href="#"><i
									class="fa far fa-bell" style="color: #9B4819; font-size: 34px"></i></a>
							</li>
							<li class="nav-item ms-4 me-3">
								<div class="dropdown">
									<a id="dropdownMenuButton12" data-bs-toggle="dropdown"
										aria-expanded="false"><i class="fa fa fa-user"
										style="color: #9B4819; font-size: 34px"></i> </a>
									<ul class="dropdown-menu"
										aria-labelledby="dropdownMenuButton12">
										<li><a class="dropdown-item" href="ProfileController">Trang cá nhân</a></li>
										<li><a class="dropdown-item" href="#">Bộ sưu tập</a></li>
										<li><a class="dropdown-item"
											href="LoginController?out=out"> Đăng xuất</a></li>
									</ul>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>