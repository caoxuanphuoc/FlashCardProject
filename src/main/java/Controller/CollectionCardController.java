package Controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Dto.UserLoginDto;
import Bo.CollectionBo;

/**
 * Servlet implementation class CollectionCardController
 */
@WebServlet("/CollectionCardController")
public class CollectionCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionCardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//init struct
			HttpSession session = request.getSession();
			CollectionBo CollectBo = new CollectionBo();

			UserLoginDto infoUser = (UserLoginDto) session.getAttribute("InfoUserLogin");
			session.setAttribute("ListCollection", CollectBo.GetCollectionByDate(true));
			
			//--------Check-login-----------
			
			if(infoUser == null ) {
				RequestDispatcher rd = request.getRequestDispatcher("LoginController");
				rd.forward(request, response);
			}
			
			//------------Add-collection-card-------------
			String NameCollect = (String) request.getParameter("NameCollect");
			String DiscriptCollect = (String) request.getParameter("DiscriptCollect");
			if( NameCollect !=null && DiscriptCollect !=null) {
			 CollectionBo CollecBO = new CollectionBo();
			 CollecBO.Create(infoUser.getUserId(), NameCollect, DiscriptCollect);
			 response.sendRedirect("GateWayController?Gate=ADD_COLLECTION");
			}
			RequestDispatcher rd = request.getRequestDispatcher("WebContent/CollectionCard.jsp");
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
