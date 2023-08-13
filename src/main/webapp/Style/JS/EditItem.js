//------------------------------------------------------------
function addCard() {
    var newItem = document.createElement("div");
    var paren = document.getElementById("ListItem");
    var k = paren.childElementCount +1;
    newItem.classList.add("row")
    newItem.id ="Item";
    newItem.innerHTML = `
                            <div class="card mt-3 rounded shadow-sm ">
                                <div class="card-body">
                                    <div class="row pb-3 mb-3 border-bottom">
                                        <span class="col"> `+k+`</span>
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
                                        	
                                        	<span id="subfileimg`+k+`" onclick="upfile('file`+k+`')" style="border-style: dotted" class="p-3" role="button">
	                                        	<i class="fa-regular fa-image mt-3 pt-2 pb-2"></i>
                                        	</span>
                                        	<input onchange="preView('fileimg`+k+`')" id = "file`+k+`" name="File" type="file" style="display: none">
                                        	
                                            <img id="fileimg`+k+`"  src="" style="display: none"
                                                class="card-img-right col-6" alt="chua co">
                                                
                                        </div>
                                        </form>
                                  <!--   </div> -->
                                </div>
                            </div>`;
    paren.appendChild(newItem);
};