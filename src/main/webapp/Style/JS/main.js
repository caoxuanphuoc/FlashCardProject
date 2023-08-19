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
					      showNoti("Suvvy","Đổi mật khẩu thành công")
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
   
//-------------NOtify---------------------
function showNoti(title,message) {
		var toastTitle = document.getElementById("toastTitle");
    	var toastMessage = document.getElementById("toastMessage");
	
		toastTitle.textContent = title;
    toastMessage.textContent = message;
        var toast = new bootstrap.Toast(document.getElementById("liveToast"));
        toast.show();
    };
//--------------SEARCH PAGE-------------------- 
 //Button Follow
function FollowUser(userId, friendId, unFl) {
		var xhr = new XMLHttpRequest();
		var url ="FriendController?UserId="+userId+ "&FriendId="+friendId;
		console.log(typeof(unFl));
		if(unFl== "true")
			url =url + "&UnFollow=1";
       xhr.open("GET", url ,  true);
       xhr.onreadystatechange = function() {
           if (xhr.readyState === XMLHttpRequest.DONE) {
               if (xhr.status === 200) {
				   console.log("hahahah" + unFl )
				  if(unFl=="unFL"){
					  console.log("do");
					  let btn_unfollow = document.getElementById("btn_unfollow");
	            	  btn_unfollow.classList.toggle('bnt-borrow');
	            	  btn_unfollow.innerHTML = `Follow <i class="fa-regular fa-square-plus"></i>`;
					  btn_unfollow.id ="btn_follow";
	            	  showNoti("Suvvy Social", "Đã hủy follow");
				  }else{
					  console.log("ngon");					  
	            	  let btn_follow = document.getElementById("btn_follow");
	            	  btn_follow.classList.toggle('btn-unBorrow');
	            	  btn_follow.innerHTML = `Followed  <i class="fa-regular fa-circle-check"></i>`;
	            	  btn_follow.id ="btn_unfollow";
	            	  showNoti("Suvvy Social", "Đã follow");
				  }
               } else {
                   console.error("Error:", xhr.statusText);
               }
           }
       };
       xhr.send();
 }; 
  
  
  
  