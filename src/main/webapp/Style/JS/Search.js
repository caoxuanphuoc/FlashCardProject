function GetPreView(collectId, keyword)  {
            	var xhr = new XMLHttpRequest();
            	var contentDiv = document.getElementById("PreView");
                xhr.open("GET", "PreviewComponent?ShowPreViewId="+collectId +"&KeyWord="+ keyword , true);
                
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === XMLHttpRequest.DONE) {
                        if (xhr.status === 200) {
                        	contentDiv.innerHTML = xhr.responseText;
                        } else {
                            console.error("Error:", xhr.statusText);
                        }
                    }
                };
                xhr.send();
            }
            
 function Pagination(NumberOfInPage,Page, KeyWord)  {
            	var xhr = new XMLHttpRequest();
            	var contentDiv = document.getElementById("SearchResult");
                xhr.open("GET", "PaginationComponent?NumberOfInPage="+NumberOfInPage +"&Page="+ Page+"&KeyWord="+KeyWord, true);
                
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === XMLHttpRequest.DONE) {
                        if (xhr.status === 200) {
                        	contentDiv.innerHTML = xhr.responseText;
                        } else {
                            console.error("Error:", xhr.statusText);
                        }
                    }
                };
                xhr.send();
            }
            
            