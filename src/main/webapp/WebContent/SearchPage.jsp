<%@page import="java.math.MathContext"%>
<%@page import="java.io.Console"%>
<%@page import="Bean.Card"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="Bean.Dto.CollectionDetailDto"%>
<%@page import="Bean.Dto.CollectionDtos.Collectiondto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    	<script src="Style/JS/Search.js" type="text/javascript"></script>
    </head>
<%
	ArrayList<Collectiondto> DataSearch = (ArrayList<Collectiondto>) session.getAttribute("ResultSearch");
	String KeyWord = (String) session.getAttribute("KeyWord");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	int NumberOfInPage = 5;
%>
<body style="background-color: #f6f7fb;">
<%@include file="Share/HeaderForLogged.jsp"%>
    <!-- Start Content -->
    <div class="container pt-5">
        <div class="row ">
            <!-- Start Col main -->
            <div class="col">
            <!-- Header Search -->
                <div class="row mb-3">
                    <div class="col">
                        <h4 class="mt-5"> Kết quả cho tìm kiếm</h4>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col">
                        <h5>Bộ lọc</h5>
                        <div class="d-flex ">
                            <div class="dropdown">
                                <button class="btn btn-white dropdown-toggle bo bg-white" type="button"
                                    id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    Bạn bè
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="#">Tất cả</a></li>
                                    <li><a class="dropdown-item" href="#">Bạn bè</a></li>
                                </ul>
                            </div>
                            <div class="dropdown ps-5">
                                <button class="btn btn-white dropdown-toggle bo bg-white" type="button"
                                    id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
                                    Số lượng thuật ngữ
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                                    <li><a class="dropdown-item" href="#">Dưới 50</a></li>
                                    <li><a class="dropdown-item" href="#">Trên 50</a></li>
                                    <li><a class="dropdown-item" href="#">Tất cả</a></li>
                                </ul>
                            </div>
                            <div class="dropdown ps-5" >
                                        <section >
                                        <form>
                                            <div class="row form-group d-flex">
                                                <label for="date" class="col-sm-2 col-form-label">From:</label>
                                                <div class="col-sm-8">
                                                    <div class="input-group date d-flex" id="datepicker">
                                                        <input type="text" class="form-control col-8" >
                                                        <span class="input-group-append col-4 d-flex">
                                                            <span class="input-group-text bg-white">
                                                                <i class="fa fa-calendar"></i>
                                                            </span>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </section>
                            </div>
                            <div class="dropdown ps-5" >
                                <section >
                                <form>
                                    <div class="row form-group d-flex">
                                        <label for="date" class="col-sm-1 col-form-label">To:</label>
                                        <div class="col-sm-8">
                                            <div class="input-group date d-flex" id="datepicker2">
                                                <input type="text" class="form-control col-8" >
                                                <span class="input-group-append col-4 d-flex">
                                                    <span class="input-group-text bg-white">
                                                        <i class="fa fa-calendar"></i>
                                                    </span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </section>
                    </div>
                        </div>
                    </div>
                </div>
           <!-- End Header Search  -->
                <div class="row">
                <!-- Start Column Họcphan -->
                    <div class="col-4 ">
                        <h3 class="ps-4">Học phần</h3>
                        <div  style="height: 500px; overflow: auto;">
                        <div id="SearchResult">
                        <%
                        if(DataSearch.size()==0){%>
                        	<h5><i>Không tìm thấy kết quả phù hợp</i></h5>
                        <%}else{
                        for(int i = 0; i< Math.min(DataSearch.size(), NumberOfInPage); i++) {
                        	Collectiondto item = DataSearch.get(i);
                        %>
                                <div class="card shadow-sm p-2 mb-3 bg-body rounded position-relative"
                                    style="border-radius: 20px !important">
                            		<a href="#" class="text-decoration-none text-black ">
	                                    <div class="card-body p-3 d-flex flex-column">
	                                        <h5 class="card-title"><%=item.getCollectionName() %></h5>
	                                        <div class="mb-5 mt-2"><span class="card-text rounded-pill ps-3 pe-3 pt-1  pb-1"
	                                                style="background-color: #edefff; font-size: 0.875rem ;font-weight: 600"><%=item.getQuantity() %> Thuật ngữ</span></div>
	                                        <div class="d-flex justify-content-between">
	                                        	<div>
	                                            <span> <img alt="atv" style="width: 25px;"
	                                                    src="https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg">
	                                            </span>
	                                            <span class="badge bg-success p-2 fs-6">@<%=item.getUserName() %></span>
	                                            </div>
	                                        </div>
	                                    </div>
                            		</a>
                                    <div onclick="GetPreView('<%=item.getId()%>','<%=KeyWord %>')" class="btn btn-outline-success position-absolute " style="top: 68%; left: 65%"> Xem trước</div>
                                </div>
                            <%}} %>
                            </div>
                            <!-- Start paging -->
                            <%if(DataSearch.size()!=0){%> 
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                  <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous">
                                      <span aria-hidden="true">«</span>
                                    </a>
                                  </li>
                                  <% int n =0;
                                  	if(DataSearch.size()%NumberOfInPage ==0)
                                  		n= DataSearch.size() /NumberOfInPage;
                                  	else n= DataSearch.size() /NumberOfInPage + 1;
                                  	int k= 0, limit= 4, ok=1;
                                  for(int i=1; i<= n ; i++) {
                                  		k++;
                                  		if(k == limit)ok=0;	
                                  		if(ok==1 || i==n){		
                                  	%>
                                      <li class="page-item"><div id = "page-<%=i%>" onclick="Pagination('<%=NumberOfInPage %>','<%=i%>','<%=KeyWord%>')" class="page-link" role="button"><%=i %></div></li>
                                  <%}else {if(limit!=-1){
                                  		limit =-1;%>
                                  		<span class="ps-3 pe-3">...</span>
                                  	<%}}} %>
                                  <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next">
                                      <span aria-hidden="true">»</span>
                                    </a>
                                  </li>
                                </ul>
                              </nav>
                              <%} %>
                               <!-- Start paging -->
                        </div>
                    </div>
                    <div class="col-8 ">
                        <h3 class="ps-4">Xem trước</h3>
                        <% 
                        	CollectionDetailDto DataPre = (CollectionDetailDto) session.getAttribute("ShowCollect");
                        %>
                        <div id="PreView" class="card shadow-sm p-2 mb-3 bg-body rounded "
                            style="border-radius: 20px !important; height: 540px">
                            <div class="d-flex justify-content-between p-2 align-items-center border-bottom">
                                <div class="d-flex border rounded">
                                    <div class="d-flex flex-column "> 
                                    	<span class="   rounded p-1" style="font-size: 20px; font-weight:20px; color: rgb(155,72,25)">
                                            <img alt="atv" style="width: 25px;"
                                            src="https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg">
                                            @<%=DataPre.getUserName() %> <i class="fa-regular fa-circle-check"></i>
                                            </span>
                                        <div class="btn text-white p-1" style="background-color: rgb(155,72,25)"> Follow </div>
                                    </div>
                                </div>
                                <div>
                                	<h3><%=DataPre.getCollectionName() %></h3>
                                </div>
                                <div><a class="btn btn-success" href="#" role="button">Học</a></div>
                            </div>

                            <div class="card-body p-3 d-flex flex-column" style="overflow: auto; height: 400px;">
                                <%for(Card item : DataPre.getListCard()) {%>
                                <div class="mb-3 row">
                                    <div class="col-9">
                                        <h3> <%=item.getFrontText() %></h3>
                                        <p style="font-size: 15px; font-weight: 2px;"> <%=item.getBackText() %></p>
                                    </div>
                                    <div class="col-3">
                                    	<%if(item.getImgBack().length() >0){ %>
                                        <img class="col-9" src="https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg" alt="ảnh">
                                    	<%} %>
                                    </div>
                                </div>
                                <%} %>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Col main -->
        </div>

    </div>
    <!-- End Content -->
    <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
        });
        $(function() {
            $('#datepicker2').datepicker();
        });
    </script>
    <div class="border-top mt-5 pt-5 ps-5" style="background-color: #9b4819">
    <%@include file="Share/FooterSimple.jsp"%>
    </div>
</body>

</html>