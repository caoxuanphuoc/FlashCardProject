<%@page import="Bean.Dto.FamousRateViewDto"%>
<%@page import="Bean.Dto.CollectionDtos.Collectiondto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link rel="styleSheet" href="Style/BaseStyle.css">
</head>
<%
	FamousRateViewDto dataRate = (FamousRateViewDto) session.getAttribute("FamousRate");
%>
<body style="background-color: #f6f7fb">
<%@include file="Share/HeaderForLogged.jsp" %>
   <div class="container pt-5">
	<div class="row pt-2">
		<main id="main" class="main">

    <div class="pagetitle pb-5">
      <h1>Profile</h1>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                <div class="d-flex align-items-center">
                    <img src="https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg" alt="Profile" class="rounded-circle col-5">
                    <div class="ps-3">
                        <h3>${InfoUserLogin.getFullName() }
                        </h3>
                            <h5 ><i>@${ InfoUserLogin.getUserName()}</i></h5>
                            
                        <button style="background-color: #fe2c55;" class="btn text-white col-12">Follow</button>
                    </div>
                </div>
                <div class="pt-4 d-flex p-1 col-8 col-lg-12 justify-content-between  ">
                        <div class="d-flex  align-items-center"> <strong><%=dataRate.getFollowing() %></strong> <span class="ps-1 pe-1">Following</span></div>
                        <div class="d-flex  align-items-center"> <strong><%=dataRate.getFollower() %></strong> <span class="ps-1 pe-1">Followes</span></div>
                        <div class="d-flex  align-items-center"> <strong><%=dataRate.getRate() %></strong> <span class="ps-1 pe-1">Rate</span></div>
                </div>
                <p class="pt-4">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                </p>
            </div>
        </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">Bộ sưu tập</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Change Password</button>
                </li>

              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">
                  <h5 class="card-title">About</h5>
                  <p class="small fst-italic">Là thành viên tích cực của suvvy</p>

                  <h5 class="card-title">Profile Details</h5>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Full Name</div>
                    <div class="col-lg-9 col-md-8">Cao Xuân Phước</div>
                  </div>

                </div>
                <div class="tab-pane fade pt-3" id="profile-settings">

                  <!-- Settings Form -->
                  <div class="d-flex flex-wrap col-12 "> 
                  <%
                  ArrayList<Collectiondto> data = (ArrayList<Collectiondto> ) session.getAttribute("CollectionByProfile");
                  for(Collectiondto item : data){ %>
                  	<div class="col-sm-4 p-2">
                        <div class="card shadow-sm p-2 mb-3 bg-body rounded"
                            style="border-radius: 20px !important">
                    <a href="CollectionDetailController?CollectionId=<%= item.getId()%>"
                        class="text-decoration-none text-black" style="height: 200px">
                            <div class="card-body p-3">
                                <h5 class="card-title"><%=item.getCollectionName() %></h5>
                                <p class="card-text mb-5 mt-2"><%=item.getQuantity() %> Thuật ngữ</p>
                                <span class="mt-4"><%=item.getDescribe() %></span>
                            </div>
                    </a>
                        </div>
                </div>
                <%} %>
                  </div>
                  
                  <!-- End settings Form -->

                </div>

                <div class="tab-pane fade pt-3" id="profile-change-password">
                  <!-- Change Password Form -->
                  <form>

                    <div class="row mb-3">
                      <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="password" type="password" class="form-control" id="currentPassword">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="newpassword" type="password" class="form-control" id="newPassword">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="renewpassword" type="password" class="form-control" id="renewPassword">
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Change Password</button>
                    </div>
                  </form><!-- End Change Password Form -->

                </div>

              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->
	</div>
</div>
</body>
</html>