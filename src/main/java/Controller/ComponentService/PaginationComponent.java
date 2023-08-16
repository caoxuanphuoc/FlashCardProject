package Controller.ComponentService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Dto.CollectionDtos.Collectiondto;

/**
 * Servlet implementation class PaginationComponent
 */
@WebServlet("/PaginationComponent")
public class PaginationComponent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginationComponent() {
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
			ArrayList<Collectiondto> DataSearch = (ArrayList<Collectiondto>) session.getAttribute("ResultSearch");
			String pageEle = request.getParameter("NumberOfInPage");
			String page = request.getParameter("Page");
			String KeyWord = request.getParameter("KeyWord");
			String TextHtml ="";
			if(DataSearch!=null && DataSearch.size()>0) {
				if(pageEle!=null && page!=null) {
					int num = Integer.parseInt(pageEle);
					int Pages = Integer.parseInt(page);
					for(int i=(num*(Pages-1)); i< Math.min(num*(Pages-1) + num,DataSearch.size()) ;i++) {
						Collectiondto item = DataSearch.get(i);
						TextHtml = TextHtml + 
								" <div class=\"card shadow-sm p-2 mb-3 bg-body rounded position-relative\"\r\n"
								+ "                                    style=\"border-radius: 20px !important\">\r\n"
								+ "                            		<a href=\"#\" class=\"text-decoration-none text-black \">\r\n"
								+ "	                                    <div class=\"card-body p-3 d-flex flex-column\">\r\n"
								+ "	                                        <h5 class=\"card-title\">"+ item.getCollectionName() + "</h5>\r\n"
								+ "	                                        <div class=\"mb-5 mt-2\"><span class=\"card-text rounded-pill ps-3 pe-3 pt-1  pb-1\"\r\n"
								+ "	                                                style=\"background-color: #edefff; font-size: 0.875rem ;font-weight: 600\">"+item.getQuantity() + " Thuật ngữ</span></div>\r\n"
								+ "	                                        <div class=\"d-flex justify-content-between\">\r\n"
								+ "	                                        	<div>\r\n"
								+ "	                                            <span> <img alt=\"atv\" style=\"width: 25px;\"\r\n"
								+ "	                                                    src=\"https://anhdep123.com/wp-content/uploads/2021/02/anh-avatar-hai-huoc.jpg\">\r\n"
								+ "	                                            </span>\r\n"
								+ "	                                            <span class=\"badge bg-success p-2 fs-6\">@"+ item.getUserName()+ "</span>\r\n"
								+ "	                                            </div>\r\n"
								+ "	                                        </div>\r\n"
								+ "	                                    </div>\r\n"
								+ "                            		</a>\r\n"
								+ "                                    <div onclick=\"GetPreView('"+ item.getId()+ "','"+ KeyWord + "')\" class=\"btn btn-outline-success position-absolute \" style=\"top: 68%; left: 65%\"> Xem trước</div>\r\n"
								+ "                                </div>";
					}
				}
			}else {
				TextHtml = "<h5><i>Không tìm thấy kết quả phù hợp</i></h5>";
			}
			response.getWriter().write(TextHtml);
		} catch (Exception e) {
			e.printStackTrace();
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
