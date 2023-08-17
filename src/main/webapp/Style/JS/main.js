function ChangePassWord(UserId)  {
    var Password = document.getElementById("Password").value;
    var NewPass = document.getElementById("NewPass").value;
    var ReNewPass = document.getElementById("ReNewPass").value;
    //-------------------------
    var NotiPass = document.getElementById("NotiPass");
	var NotiNewPass = document.getElementById("NotiNewPass");
	var NotiReNewPass = document.getElementById("NotiReNewPass");
	var NotiChange =document.getElementById("NotiChange");
    if(NewPass != ReNewPass){
		NotiReNewPass.innerHTML = "Mật khẩu xác nhận không khớp";
	}else{
   	   var xhr = new XMLHttpRequest();
       xhr.open("POST", "ChangePassController?UserId="+UserId+ "&Password="+Password +"&NewPass="+ NewPass, true);
       
       xhr.onreadystatechange = function() {
           if (xhr.readyState === XMLHttpRequest.DONE) {
               if (xhr.status === 200) {
            	   var res = xhr.responseText;
            	   if(res=="OK"){
		               	var ResetPassword = document.getElementById("Password");
					    var ResetNewPass = document.getElementById("NewPass");
					    var ResetReNewPass = document.getElementById("ReNewPass");
					    ResetPassword.value ="";
					     ResetNewPass.value ="";
					      ResetReNewPass.value ="";
					      NotiChange.innerHTML = "Đổi mật khẩu thành công";
	               		}else{
               			NotiPass.innerHTML ="Mật khẩu không hợp lệ"
               			}
               			
               } else {
                   console.error("Error:", xhr.statusText);
               }
           }
       };
       xhr.send();
       
       }
   }