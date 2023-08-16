package Controller;

import java.io.IOException;

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
 * Servlet implementation class HomeForUserController
 */
@WebServlet("/HomeForUserController")
public class HomeForUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeForUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//--------------init-everything
		HttpSession session = request.getSession();
		CollectionBo Collection = new CollectionBo();
		UserLoginDto infoUser = (UserLoginDto) session.getAttribute("InfoUserLogin");
		
		//------check-if-logged-don't show form login"
			if(infoUser==null) {
				RequestDispatcher rd = request.getRequestDispatcher("LoginController");
				rd.forward(request, response);
				return;
			}	
		//-------------Default-Sesion----------------
			// List info Collection
			session.setAttribute("ListColletion", Collection.GetAllByUser(infoUser.getUserId()));
			
		//-------------END-of-Default-Sesion----------
			RequestDispatcher rd = request.getRequestDispatcher("WebContent/HomeForUser.jsp");
			rd.forward(request, response);
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
