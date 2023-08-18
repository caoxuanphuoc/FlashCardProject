<%@page import="Bean.Card"%>
<%@page import="Bean.Dto.CollectionDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="styleSheet" href="Style/BaseStyle.css">
<script src="https://kit.fontawesome.com/b220baa0bb.js"
	crossorigin="anonymous"></script>
<script src="Style/JS/EditItem.js"></script>
<script src="Style/JS/main.js"></script>
</head>
<!-- init every thing -->
<%
 	CollectionDetailDto Data = (CollectionDetailDto) session.getAttribute("CollectionForEdit");	
 %>
<body style="background-color: #f6f7fb;">
	<%@include file="Share/HeaderForLogged.jsp"%>
	<div class="container ">
		<div class="row pt-5">
			<!-- Start main col -->
			<div class="col">
				<!-- Start Header -->
				<div class="row mb-5 pt-5">
					<div class="col">
						<!-- Start Back and save -->
						<div class="row" style="height: 100px;">
							<div class="col-6">
								<span role="button"> <span><i
										class="fa-solid fa-chevron-left"></i></span> <a
									href="CollectionDetailController?CollectionId=<%= Data.getId() %>"><span
										class="fs-6"> <b>Trở về bộ sưu tập </b></span></a>
								</span>
							</div>
							<div class="col-6 text-end">
								<span role="button"
									class="p-2 mt-1 text-white rounded shadow-sm bnt-borrow"> <span><i
										class="fa-solid fa-floppy-disk pe-1 "></i></span> <span>Hoàn
										tất</span>
								</span>
							</div>
						</div>
						<!-- End Back and save -->

						<!-- Start -info Colletion -->
						<div class="row mb-3">
							<div class="col-6">
								<form action="xxx" class="d-flex flex-column">
									<!--  -->
									<input type="text" class="pb-3"
										value="<%= Data.getCollectionName() %>"
										style="outline: none; border: none; border-bottom: 2px solid #726c6c; background-color: #f6f7fb;">
									<label for="exampleInput" class="form-label  pt-2">TIÊU
										ĐỀ</label> <input type="text" class="pb-3"
										value="<%= Data.getDescribe() %>"
										style="outline: none; border: none; border-bottom: 2px solid #726c6c; background-color: #f6f7fb;">
									<label for="exampleInput" class="form-label  pt-2">MÔ
										TẢ</label>
								</form>
							</div>
						</div>
						<!-- End -info Colletion -->

						<!-- Start collection option -->
						<div class="row pt-3">
							<div class="col-6">
								<span class="p-2 text-white rounded shadow-sm bnt-borrow"  role="button"> <span><i
										class="fa-solid fa-plus"></i> Nhập</span>
								</span>
							</div>
							<div class="col-6 text-end">
								<span role="button"
									class=" pt-1 pb-1  rounded-circle me-3 shadow-sm bnt-borrow"
									style=" font-size: 25px;"> <i
									id="dropdownMenuButton3" data-bs-toggle="dropdown"
									aria-expanded="false" class="fa-solid fa-gear ps-2 text-white"></i>
									<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
										<li><div class="dropdown-item" data-bs-toggle="modal"
												data-bs-target="#RoleCollection">Quyền truy cập</div></li>
										<li><a class="dropdown-item"
											href="CollectionEditController?IdCOllectionDelete=<%= Data.getId()%>">Xóa</a></li>
									</ul>
								</span> <span role="button"
									class=" pt-1 pb-1  rounded-circle shadow-sm bnt-borrow"
									style=" font-size: 25px;"><i
									class="fa-solid fa-right-left p-2 text-white"></i></span>

							</div>
						</div>
						<!-- end collection option -->
					</div>
				</div>

				<!-- end Header -->

				<!-- Start List card -->
				<div class="row pb-5">
					<div class="col" id="ListItem">
						<!-- Start Item -->
						<% int index =0; 
                    response.setCharacterEncoding("utf-8");
            		request.setCharacterEncoding("utf-8");
                    for( Card item : Data.getListCard()) { index++;%>
						<div class="row" id="Item">
							<div class="card mt-3 rounded shadow-sm ">
								<div class="card-body">
									<div class="row pb-3 mb-3 border-bottom">
										<span class="col"> <%=index %></span> <span
											class="col text-end"><i
											class="fa-solid fa-trash-can pe-5"></i></span>
									</div>
									<!--  <div class="row "> -->
									<form class="subform d-flex row" id="<%= item.getId() %>"
										enctype="multipart/form-data">
										<div class="col-5 pt-3">
											<input name="ThuatNgu" type="text" class="col-12 p-1"
												value="<%= item.getFrontText() %>"
												style="outline: none; border: none; border-bottom: 2px solid #726c6c;">
											<label>Thuật ngữ</label>
										</div>
										<div class="col-5 pt-3">
											<input name="DinhNghia" type="text" class="col-12 p-1"
												value="<%= item.getBackText() %>"
												style="outline: none; border: none; border-bottom: 2px solid #726c6c;">
											<label>Định nghĩa</label>
										</div>
										<div class="col-2 text-center ">
											<%if(item.getImgBack().length()>0){ %>
											<img onclick="upfile('file<%=index %>')" role="button"
												id="fileimg<%=index%>" src="<%=item.getImgBack() %>"
												class="card-img-right col-8 " alt="chua co">
											<%}else{ %>
											<span id="subfileimg<%=index%>"
												onclick="upfile('file<%=index %>')"
												style="border-style: dotted" class="p-3" role="button">
												<i class="fa-regular fa-image mt-3 pt-2 pb-2"></i>
											</span>
											<%} %>
											<input onchange="preView('fileimg<%=index%>')"
												id="file<%=index%>" name="File" type="file"
												style="display: none"> <img
												onclick="upfile('file<%=index %>')" role="button"
												id="fileimg<%=index%>" src="" style="display: none"
												class="card-img-right col-8 " alt="Ảnh">
										</div>
									</form>
									<!--   </div> -->
								</div>
							</div>
						</div>
						<%} %>
						<!-- End-item -->

					</div>
				</div>
				<!-- End List card -->

				<!-- Start Add item area -->
				<div class="row">
					<div class="col">
						<!-- start add item -->
						<div id="AddItem" class="row " role="button" onclick="addCard()">

							<div class="card rounded shadow-sm ">
								<div class="card-body text-center pt-5 pb-5">

									<span class="border-bottom border-5"> <i
										class="fa-solid fa-plus"></i> <span><b>THÊM THẺ</b></span>
									</span>
								</div>
							</div>
						</div>
						<!-- End add Item -->
						<!-- Start finish buton -->
						<div class="row pt-5">
							<div class="text-end">
								<!-- <a href = "CollectionDetailController?CollectionId=<%= Data.getId() %>"> -->
								<span onclick="SendForm(`<%=Data.getId()%>`)" role="button"
									
									class="p-4 text-white shadow rounded fs-5 fw-5 bnt-borrow">Hoàn
									tất</span>
								<!-- </a>   -->
							</div>
						</div>
						<!-- End finish buton -->
					</div>
				</div>
				<!-- End Add item area -->
			</div>
			<!-- End main col -->
		</div>
	</div>

	<div class="border-top mt-5 pt-5 ps-5"
		style="background-color: #9b4819">
		<%@include file="Share/FooterSimple.jsp"%>
	</div>
	

	<!-- Modal -->
	<div class="modal fade pt-5 " id="RoleCollection" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog pt-5 ">
			<div class="modal-content">
				<div class="modal-header" style="background-color: rgb(155, 72, 25)">
					<h3 class="modal-title text-white " id="exampleModalLabel">Tùy
						chọn</h3>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-5 ms-4">
							<h5>AI CÓ THỂ HỌC</h5>
							<select id="RoleView" class="form-select"
								aria-label="Default select example" onchange="ChangeShow_View()">
								<option selected value="1">Mọi người</option>
								<option value="2">Người có mật khẩu</option>
								<option value="3">Chỉ tôi</option>
								<option value="4">Người đã theo dõi</option>
							</select>
							<p id="NotiRoleView">Mọi người có thể xem được bộ sưu tập này</p>
						</div>
						<div class="col-5">
							<h5>AI CÓ THỂ SỬA</h5>
							<select class="form-select" aria-label="Default select example">
								<option selected>Chỉ tôi</option>
								<option value="1">Người có mật khẩu</option>
							</select>
							<p>Chỉ bạn mới có thể xem được bộ sưu tập này</p>
						</div>
					</div>
				</div>
				<div class="modal-footer d-flex justify-content-center">
					<button type="button" data-bs-dismiss="modal" id="liveToaaastBtn"
						class="btn col-10 p-3 bnt-borrow"
						style=" color: white" onclick="ChangeRoleCollection('<%=Data.getId()%>')">LƯU</button>
				</div>
			</div>
		</div>
	</div>

	<!-- End Modal -->
	<!-- Start noti -->
		<div class="position-fixed bottom-0 end-0 p-3 " style="z-index: 11">
		<div id="liveToast" class="toast hide" role="alert"
			aria-live="assertive" aria-atomic="true">
			<div class="toast-header d-flex justify-content-between bg-success text-white" >
					<b id="toastTitle"> class="me-auto">Bootstrap</b>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
			<div class="toast-body" id="toastMessage">Hello, world! This is a toast message.
			</div>
		</div>
	</div>
	<!-- End noti -->
</body>

</html>