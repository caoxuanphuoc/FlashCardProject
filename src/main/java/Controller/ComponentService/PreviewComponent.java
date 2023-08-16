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
import Bean.Dto.CollectionDtos.Collectiondto;
import Bo.CollectionBo;

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
			CollectionDetailDto resu = new CollectionDetailDto();
			
		String KeyWord = (String) request.getParameter("KeyWord");
		String idcollect = (String) request.getParameter("ShowPreViewId");
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
			String textHtml ="<div class=\"d-flex justify-content-between p-2\">\r\n"
					+ "                                <div class=\"d-flex\">\r\n"
					+ "                                    <h2>" + resu.getCollectionName() +"</h2>\r\n"
					+ "                                    <span>\r\n"
					+ "                                        <img alt=\"atv\" style=\"width: 25px;\"\r\n"
					+ "                                            src=\"https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg\">\r\n"
					+ "                                    </span>\r\n"
					+ "                                    <div> <span class=\" bg-success  rounded p-1\" style=\"font-size: 14px;\">\r\n"
					+ "                                            @"+ resu.getUserName() +"</span></div>\r\n"
					+ "                                </div>\r\n"
					+ "                                <div><a class=\"btn btn-primary\" href=\"#\" role=\"button\">Học</a></div>\r\n"
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
