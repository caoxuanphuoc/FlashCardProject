<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="Public/Img/logo_v3_rb.png">
<title>Insert title here</title>
<link rel="styleSheet"
	href="Style/bootstrap-5.0.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="row d-flex position-relative">
		<div class="col-md-6 position-fixed">
			<img alt="" src="Public/Img/LoginBanner.png" class="col-12">
		</div>
		<div id="content" class="col-6 position-relative start-50 ">
			<div class="pt-5 offset-md-2 d-flex" >
			<a href="HomeController" style="width:50px; height:50px">
				<img alt="logo" src="Public/Img/logo_v3_rb.png" style="width:100%; height:100%">
			</a>
					<h1 class=" ps-3" style="color: #9B4819">Đăng nhập</h1>
			</div>
			<div class="col-8 border border-success mt-4 ps-6 p-5 rounded-3 d-flex justify-content-center
			 position-absolute start-50 translate-middle-x shadow p-3 mb-5 bg-body rounded">
				<form class="col-10" action="LoginController" method="get">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">
						<b>UserName</b> </label> <input class="form-control" name="UserName"
							>
						<div  class="form-text">We'll never share your
							email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label"><b> Password</b></label>
						<input type="password" class="form-control"
							id="exampleInputPassword1" name="Pass">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
						<label class="form-check-label" for="exampleCheck1">Remember me</label>
					</div>
					<span><i> Chưa có tài khoản: </i><a href="#" onclick="Res()">Đăng ký</a></span>
					<div class="d-flex justify-content-center pt-2">
					<button type="submit" class="btn btn-outline-success " >Đăng nhập</button>
					</div>
				</form>

			</div>
		</div>
	</div>

<script >
function Res() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("content").innerHTML = this.responseText;
        }
    //Gửi request và truyền tham số
    xhttp.open("POST", "WebContent/Auth/RegisterForm.jsp", true);
    xhttp.send();
    }
function Reg()  {
	var username = document.getElementById("un").value;
    var email = document.getElementById("email").value;
    var password1 = document.getElementById("Password1").value;
    var password2 = document.getElementById("Password2").value;
   	var xhr = new XMLHttpRequest();
       xhr.open("POST", "RegController?username="+username +"&email="+ email+ "&password1="+ password1 + "&password2=" + password2, true);
       
       xhr.onreadystatechange = function() {
           if (xhr.readyState === XMLHttpRequest.DONE) {
               if (xhr.status === 200) {
            	   var arr = xhr.responseText.split("***");
            	   if(arr[0]=="Error"){
	            	   	var unNoti = document.getElementById("NotiUN");
	            	   	var EmailNoti = document.getElementById("NotiEmail");
	            	   	var PassNoti = document.getElementById("NotiPass");
	            	   	console.log("OK: " + xhr.responseText)
	               		unNoti.innerHTML = arr[1].split("-")[1];
	            	   	EmailNoti.innerHTML = arr[2].split("-")[1];
	            	   	PassNoti.innerHTML = arr[3].split("-")[1];
               		}else{
               			//console.log("chuyen huong");
               			window.location.href="GateWayController?Gate=OK";
               		}
               } else {
                   console.error("Error:", xhr.statusText);
               }
           }
       };
       xhr.send();
   }
</script>
</body>
</html>