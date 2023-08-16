package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Card;
import Bean.CollectionCard;
import Bean.Dto.CollectionDetailDto;
import Bo.CardBo;
import Bo.CollectionBo;

/**
 * Servlet implementation class CollectionDetailController
 */
@WebServlet("/CollectionDetailController")
public class CollectionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//----------------init every
			HttpSession session = request.getSession();
			CardBo cardb = new CardBo();
			CollectionBo Colb= new CollectionBo();
			//----------------------------------------
			//--------------Get--Collection- by CollectionId
			String collecId = (String) request.getParameter("CollectionId");
			if(collecId!=null) {
				Long ID = Long.parseLong(collecId);
				CollectionDetailDto Dto = Colb.GetColectDetailById(ID);
				session.setAttribute("DSCardByID", Dto);
				if(Dto.getListCard().size()==0) {
					RequestDispatcher rd = request.getRequestDispatcher("CollectionEditController?IdCOllection=" + Dto.getId());
					rd.forward(request, response);
				}
			}
//Xử lý khi không có tham số truyền vào.
//			else {
//				RequestDispatcher rd = request.getRequestDispatcher("HomeForUserController");
//				rd.forward(request, response);
//			}
			
			RequestDispatcher rd = request.getRequestDispatcher("WebContent/CollectionDetail.jsp");
			rd.forward(request, response);
			
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
