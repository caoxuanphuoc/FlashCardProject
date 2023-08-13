<%@page import="Bean.Card"%>
<%@page import="Bean.Dto.CollectionDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="styleSheet" href="Style/BaseStyle.css">
    <script src="https://kit.fontawesome.com/b220baa0bb.js" crossorigin="anonymous"></script>

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
                        <div class="row" style="height: 100px; ">
                            <div class="col-6">
                                <span role="button">
                                    <span><i class="fa-solid fa-chevron-left"></i></span>
                                    <a href="CollectionDetailController"><span class="fs-6"> <b>Trở về bộ sưu tập </b></span></a>
                                </span>
                            </div>
                            <div class="col-6 text-end">
                                <span role="button" class="p-2 mt-1 text-white rounded shadow-sm"
                                    style="background-color: #9b4819;">
                                    <span><i class="fa-solid fa-floppy-disk pe-1"></i></span>
                                    <span>Hoàn tất</span>
                                </span>
                            </div>
                        </div>
                        <!-- End Back and save -->

                        <!-- Start -info Colletion -->
                        <div class="row mb-3">
                            <div class="col-6">
                                <form action="xxx" class="d-flex flex-column">
                                    <!--  -->
                                    <input type="text" class="pb-3" value="<%= Data.getCollectionName() %>"
                                        style="outline: none; border: none ;border-bottom: 2px solid #726c6c; background-color: #f6f7fb;">
                                    <label for="exampleInput" class="form-label  pt-2">TIÊU
                                        ĐỀ</label>
                                    <input type="text" class="pb-3" value="<%= Data.getDescribe() %>"
                                        style="outline: none; border: none ;border-bottom: 2px solid #726c6c; background-color: #f6f7fb;">
                                    <label for="exampleInput" class="form-label  pt-2">MÔ TẢ</label>
                                </form>
                            </div>
                        </div>
                        <!-- End -info Colletion -->

                        <!-- Start collection option -->
                        <div class="row pt-3">
                            <div class="col-6">
                                <span class="p-2 text-white rounded shadow-sm" style="background-color: #9b4819;" role="button">
                                    <span><i class="fa-solid fa-plus"></i> Nhập</span>
                                </span>
                            </div>
                            <div class="col-6 text-end">
                                <span role="button" class=" pt-1 pb-1  rounded-circle me-3 shadow-sm"
                                    style="background-color: #9b4819; font-size: 25px;"><i
                                        class="fa-solid fa-gear p-2 text-white"></i></span>
                                <span role="button" class=" pt-1 pb-1  rounded-circle shadow-sm"
                                    style="background-color: #9b4819; font-size: 25px;"><i
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
                    for( Card item : Data.getListCard()) { index++;%>
                        <div class="row" id="Item">
                            <div class="card mt-3 rounded shadow-sm ">
                                <div class="card-body">
                                    <div class="row pb-3 mb-3 border-bottom">
                                        <span class="col"> <%=index %></span>
                                        <span class="col text-end"><i class="fa-solid fa-trash-can pe-5"></i></span>
                                    </div>
                                   <!--  <div class="row "> -->
                                    	<form class="subform d-flex row" id="<%= item.getId() %>">
                                        <div class="col-5 pt-3"><input name="ThuatNgu" type="text" class="col-12 p-1" value="<%= item.getFrontText() %>"
                                                style="outline: none; border: none ;border-bottom: 2px solid #726c6c;">
                                            <label>Thuật ngữ</label>
                                        </div>
                                        <div class="col-5 pt-3"><input name="DinhNghia" type="text" class="col-12 p-1" value="<%= item.getBackText() %>"
                                                style="outline: none; border: none ;border-bottom: 2px solid #726c6c;">
                                            <label>Định nghĩa</label>
                                        </div>
                                        <div class="col-2 text-center ">
                                        	
                                        	<span id="subfileimg<%=index%>" onclick="upfile('file<%=index %>')" style="border-style: dotted" class="p-3" role="button">
	                                        	<i class="fa-regular fa-image mt-3 pt-2 pb-2"></i>
                                        	</span>
                                        	<input onchange="preView('fileimg<%=index%>')" id = "file<%=index%>" name="File" type="file" style="display: none">
                                        	
                                            <img id="fileimg<%=index%>"  src="" style="display: none"
                                                class="card-img-right col-8 " alt="chua co">                        
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
                                   
                                        <span class="border-bottom border-5">
                                            <i class="fa-solid fa-plus"></i>
                                            <span><b>THÊM THẺ</b></span>
                                        </span>
                                </div>
                            </div>
                        </div>
                        <!-- End add Item -->
                        <!-- Start finish buton -->
                        <div class="row pt-5">
                            <div class="text-end">
                                <span onclick="SendForm(`<%= Data.getId() %>`)" role="button" style="background-color: #9b4819;" class="p-4 text-white shadow rounded fs-5 fw-5 ">Hoàn tất</span>
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

    <footer style="border-top: 10px solid; margin-top: 100px;">

    </footer>
    <script src="Style/JS/EditItem.js"> </script>
    <script type="text/javascript">
    function upfile(key){
    	 var fileInput = document.getElementById(key);
    	 fileInput.click();
    }
    // handle img when upload 
    function preView(keyimg){
    	 var previewImage = document.getElementById(keyimg);
    	 console.log("Id:  "+ keyimg)
    	 console.log("before: " + previewImage.src)
    	 var selectedFile = event.target.files[0];
    	  if (selectedFile) {
              var reader = new FileReader();
              reader.onload = function(event) {
                  previewImage.src = event.target.result;
            	  console.log("link: " +event.target.result)
              };
              reader.readAsDataURL(selectedFile);
              console.log("affter: " + previewImage.src)
              
              var sub = document.getElementById("sub"+keyimg);
              sub.style.display = "none";
              previewImage.style.display = "block"
          } else {
              previewImage.src = ""; // Xóa ảnh xem trước nếu không có tệp được chọn
          }
    }
    </script>
    <script type="text/javascript">
		function SendForm(collectId) {
			var listform = document.querySelectorAll(".subform");
			listform.forEach(function(form) {
				/* var childs = input.children;
				for (var i = 0; i < childs.length; i++) {
					var child = childs[i];
					console.log(child)
					console.log(child.className + " = " + child.value)
				} */
				console.log("---------------------------"+ form.id)
				var idUpdate= form.id;
				var formData = new FormData(form);
				var xhttp = new XMLHttpRequest();
				xhttp.onload = function() {
					if (xhttp.status === 200) {
						console.log("Dữ liệu đã được gửi thành công!");
					} else {
						console.error("Đã xảy ra lỗi: ", xhttp.statusText);
					}
				};
				var url = "AddCardController?meth="+idUpdate+"&idc="+collectId; // Chuỗi URL ban đầu

				if (form.id.includes("add")) {
				    // Nếu chuỗi chứa "add"
				    url = "AddCardController?meth=add&idc="+collectId; // Cập nhật giá trị của URL
				}
				xhttp.open("POST", url, false);
				xhttp.send(formData);

			});
		}
	</script>
    
</body>

</html>