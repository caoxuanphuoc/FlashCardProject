//------------------------------------------------------------
function addCard() {
	var newItem = document.createElement("div");
	var paren = document.getElementById("ListItem");
	var k = paren.childElementCount + 1;
	newItem.classList.add("row")
	newItem.id = "Item";
	newItem.innerHTML = `
                            <div class="card mt-3 rounded shadow-sm ">
                                <div class="card-body">
                                    <div class="row pb-3 mb-3 border-bottom">
                                        <span class="col"> `+ k + `</span>
                                        <span class="col text-end"><i class="fa-solid fa-trash-can pe-5"></i></span>
                                    </div>
                                   <!--  <div class="row "> -->
                                    	<form class="subform d-flex row" id="addItem">
                                        <div class="col-5 pt-3"><input name="ThuatNgu" type="text" class="col-12 p-1"
                                                style="outline: none; border: none ;border-bottom: 2px solid #726c6c;">
                                            <label>Thuật ngữ</label>
                                        </div>
                                        <div class="col-5 pt-3"><input name="DinhNghia" type="text" class="col-12 p-1"
                                                style="outline: none; border: none ;border-bottom: 2px solid #726c6c;">
                                            <label>Định nghĩa</label>
                                        </div>
                                        <div class="col-2 text-center ">
                                        	
                                        	<span id="subfileimg`+ k + `" onclick="upfile('file` + k + `')" style="border-style: dotted" class="p-3" role="button">
	                                        	<i class="fa-regular fa-image mt-3 pt-2 pb-2"></i>
                                        	</span>
                                        	<input onchange="preView('fileimg`+ k + `')" id = "file` + k + `" name="File" type="file" style="display: none">
                                        	
                                            <img id="fileimg`+ k + `"  src="" style="display: none"
                                                class="card-img-right col-6" alt="chua co">
                                                
                                        </div>
                                        </form>
                                  <!--   </div> -->
                                </div>
                            </div>`;
	paren.appendChild(newItem);
};

//------------------UPFILE-------------------------------
function upfile(key) {
	var fileInput = document.getElementById(key);
	fileInput.click();
}
// handle img when upload 
function preView(keyimg) {
	var previewImage = document.getElementById(keyimg);
	console.log("Id:  " + keyimg)
	console.log("before: " + previewImage.src)
	var selectedFile = event.target.files[0];
	if (selectedFile) {
		var reader = new FileReader();
		reader.onload = function(event) {
			previewImage.src = event.target.result;
			console.log("link: " + event.target.result)
		};
		reader.readAsDataURL(selectedFile);
		console.log("affter: " + previewImage.src)

		var sub = document.getElementById("sub" + keyimg);
		sub.style.display = "none";
		previewImage.style.display = "block"
	} else {
		previewImage.src = ""; // Xóa ảnh xem trước nếu không có tệp được chọn
	}
}
//-------------------------SendForm----------------
function SendForm(collectId) {
	var listform = document.querySelectorAll(".subform");
	listform
		.forEach(function(form) {
			var idUpdate = form.id;
			var formData = new FormData(form);
			var xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				if (xhttp.status === 200) {
					console.log("Dữ liệu đã được gửi thành công!");
					window.location.href = "CollectionDetailController?CollectionId="
						+ collectId;
				} else {
					console.error("Đã xảy ra lỗi: ",
						xhttp.statusText);
				}
			};
			var url = "AddCardController?meth=" + idUpdate
				+ "&idc=" + collectId; // Chuỗi URL ban đầu

			if (form.id.includes("add")) {
				// Nếu chuỗi chứa "add"
				url = "AddCardController?meth=add&idc=" + collectId; // Cập nhật giá trị của URL
			}
			xhttp.open("POST", url, true);
			xhttp.send(formData);

		});
}
//-----------------Change role access to collection------------------------

function ChangeShow_View() {
	var RoleView = document.getElementById("RoleView");
	var NotiRoleView = document.getElementById("NotiRoleView");
	var noti = "";
	if (RoleView.value == "1") {
		noti = "Mọi người";
	} else if (RoleView.value == "2") {
		noti = `<label>Nhập mật khẩu</label> <input type="text" id="passCollect">  Người có mật khẩu`;
	} else if (RoleView.value == "3") {
		noti = "Chỉ tôi";
	} else {
		noti = "Người đã theo dõi";
	}
	noti = noti + " có thể xem được bộ sưu tập này";
	NotiRoleView.innerHTML = noti;
}

function ChangeRoleCollection(IdColect) {
	var RoleView = document.getElementById("RoleView");
	var status = RoleView.value;
	var xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		if (xhttp.status === 200) {
			//console.log("OKKKK" + xhttp.responseText)
			showNoti('Suvvy','Thay đổi quyền thành công')
		} else {
			console.error("Đã xảy ra lỗi: ",
				xhttp.statusText);
		}
	};
	
	var url = "CollectionEditController?IdCoUpdate="+IdColect + "&Status=" + status;
	
	if(status == "2"){
		var PassCollect = document.getElementById("passCollect");
		url = url + "&PassCollect="+ PassCollect.value;
	}
	
	xhttp.open("POST", url, true);
	xhttp.send();

}











