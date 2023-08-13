<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- <form method="post" action="../tam123" enctype= "multipart/form-data">
  Ho Ten: <input type="text" name="txthoten" value=""> <br>
  Đia chi: <input type="text" name="txtdiachi" value=""> <br>
  file: <input type="file" name="txtfile"><br>
  <input type="submit"> 
 </form>  -->
	<form id="123"class="formne" enctype="multipart/form-data">
		Ho Ten: <input class="name" type="text" name="txthoten" value="">
		<br> file: <input class="file" type="file" name="txtfile"><br>

	</form>

	<form class="formne" enctype="multipart/form-data">
		Ho Ten: <input class="name" type="text" name="txthoten" value="">
		<br> file: <input class="file" type="file" name="txtfile"><br>

	</form>
	<button onclick="SendForm()">Gửi</button>

	<script type="text/javascript">
		function SendForm() {

			var listform = document.querySelectorAll(".formne");
			listform.forEach(function(form) {
				/* var childs = input.children;
				for (var i = 0; i < childs.length; i++) {
					var child = childs[i];
					console.log(child)
					console.log(child.className + " = " + child.value)
				} */
				console.log("---------------------------"+form.id )
				var formData = new FormData(form);
				var xhttp = new XMLHttpRequest();
				xhttp.onload = function() {
					if (xhttp.status === 200) {
						console.log("Dữ liệu đã được gửi thành công!");
					} else {
						console.error("Đã xảy ra lỗi: ", xhttp.statusText);
					}
				};
				xhttp.open("POST", "../tam123?meth=add", true);
				xhttp.send(formData);

			});
		}
	</script>
</body>
</html>