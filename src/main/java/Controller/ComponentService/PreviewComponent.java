package Controller.ComponentService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Card;
import Bean.Dto.CollectionDetailDto;
import Bean.Dto.UserLoginDto;
import Bean.Dto.CollectionDtos.Collectiondto;
import Bo.CollectionBo;
import Bo.FriendBo;

/**
 * Servlet implementation class PreviewComponent
 */
@WebServlet("/PreviewComponent")
public class PreviewComponent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewComponent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			CollectionBo CoBo = new CollectionBo();	
			FriendBo Fbo = new FriendBo(); 
			CollectionDetailDto resu = new CollectionDetailDto();
			
		String KeyWord = (String) request.getParameter("KeyWord");
		String idcollect = (String) request.getParameter("ShowPreViewId");
		UserLoginDto DataCurrenUser = (UserLoginDto) session.getAttribute("InfoUserLogin");
		if(idcollect!=null) {
			Long Id = Long.parseLong(idcollect);
			resu = CoBo.GetColectDetailById(Id);
		}else {
			ArrayList<Collectiondto> res = CoBo.Search(KeyWord);
			if(res.size()>0) {
				Long IdFirstColection = res.get(0).getId();
				resu= CoBo.GetColectDetailById(IdFirstColection);
			}
		}
			String textHtml ="<div class=\"d-flex justify-content-between p-2 align-items-center border-bottom\">\r\n"
					+ "<div class=\"d-flex border rounded\">\r\n"
					+ "                                    <div class=\"d-flex flex-column \"> \r\n"
					+ "                                    	<span class=\"   rounded p-1\" style=\"font-size: 20px; font-weight:20px; color: rgb(155,72,25)\">\r\n"
					+ "                                            <img alt=\"atv\" style=\"width: 25px;\"\r\n"
					+ "                                            src=\"https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg\">\r\n"
					+ "                                            @"+ resu.getUserName() +" <i class=\"fa-regular fa-circle-check\"></i>\r\n"
					+ "                                            </span>\r\n";
		            if( Fbo.IsFollow(DataCurrenUser.getUserId(), resu.getUserId()) ==true){
		        	 	//UserId - FriendID %>
		            	textHtml = textHtml+ " <div class=\"btn  p-1\" style=\"border-color: rgb(155,72,25)\"> followed </div>";
		        	
			        }else{ 
			        	
			        	textHtml = textHtml+ "<div onclick=\"FollowUser('" +DataCurrenUser.getUserId()+ "', '" +resu.getUserId()+ "')\" class=\"btn text-white p-1\" style=\"background-color: rgb(155,72,25)\"> Follow </div>      ";                                  
			        } 
					textHtml= textHtml	+ "                                    </div>\r\n"
					+ "                                </div>\r\n"
					+ "                                <div>\r\n"
					+ "                                	<h3>"+ resu.getCollectionName()+"</h3>\r\n"
					+ "                                </div>\r\n"
					+ "                                <div><a class=\"btn btn-success\" href=\"#\" role=\"button\">Học</a></div>"                               
					+ "                            </div>\r\n"
					+ "\r\n"
					+ "                            <div class=\"card-body p-3 d-flex flex-column\" style=\"overflow: auto; height: 400px;\">\r\n";
					for(Card item : resu.getListCard()) {
						textHtml = textHtml + 
								"<div class=\"mb-3 row\">\r\n"
								+ "                                    <div class=\"col-9\">\r\n"
								+ "                                        <h3> "+ item.getFrontText() +"</h3>\r\n"
								+ "                                        <p style=\"font-size: 15px; font-weight: 2px;\"> "+ item.getBackText()+"</p>\r\n"
								+ "                                    </div>\r\n"
								+ "                                    <div class=\"col-3\">\r\n";
						if(item.getBackText().length() >0)
								textHtml = textHtml + "<img class=\"col-9\" src=\"https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg\" alt=\"ảnh\">\r\n";									 
							textHtml = textHtml 
								+ "</div>\r\n"
								+ "</div>";
					}
					textHtml = textHtml + "</div>";
			response.getWriter().write(textHtml);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
