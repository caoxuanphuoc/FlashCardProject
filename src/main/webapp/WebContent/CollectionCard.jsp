<%@page import="Bean.Dto.UserLoginDto"%>
<%@page import="Bean.CollectionCard"%>
<%@page import="Bean.Dto.CollectionByDateDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link rel="styleSheet" href="Style/BaseStyle.css">
</head>
<body style="background-color: #f6f7fb">
<%@include file="Share/HeaderForLogged.jsp" %>
<div class="container pt-5"> 
 <section class="section mt-5">
      <div class="row">
      	<h1>Bộ sưu tập</h1>
        <div class="col-lg-10">
        <%
        ArrayList<CollectionByDateDto> DS = ( ArrayList<CollectionByDateDto>)session.getAttribute("ListCollection");
        UserLoginDto info = (UserLoginDto) session.getAttribute("InfoUserLogin");
        for(CollectionByDateDto paren: DS){
        	%>
        	<header  class="d-flex mt-5">
	        	<h5 style="width: 20%"><%= paren.toStringGetDate() %></h5>
	        	<div  class="d-none d-md-block" style="border-color  = #d9dde8;     width: 80%; "><hr>
	        	</div>
        	</header>
        	<%for(CollectionCard child : paren.getListCollection()) {%>
        	<a href="CollectionDetailController?CollectionId=<%= child.getId()%>">
          <div class="card mt-3 rounded shadow-sm ">
            <div class="card-body">
              <div class= "row ">
              	<div class="col-4 d-flex align-items-center"><span class="card-title fs-6 "><b> <%= paren.getQuantityCardById(child.getId()) %> thuật ngữ </b></span>
             		<span class="badge bg-success ms-3  p-2"> <b  >@<%= info.getUserName() %></b></span>
              	 </div>
              </div>
              <div class="row">
              	<div class="col-5 d-flex mt-1">
              		<h5><b><%= child.getCollectionName() %> </b></h5>
              	</div> 
              </div>
            </div>
          </div><!-- End Default Badges -->
          </a>
          <%}} %>
        </div>

      </div>
 </section>
</section>	
</div>

</body>
</html>