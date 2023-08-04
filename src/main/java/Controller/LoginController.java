package Controller;

import java.io.Console;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Dto.UserLoginDto;
import Bo.UserBo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//init
		HttpSession session = request.getSession();
		UserBo UserLog= new UserBo();
		//-----------
		
		//Handle Login
		String un = (String) request.getParameter("UserName");
		String pw = (String) request.getParameter("Pass");
		try {
		if(un!=null && pw!=null)
		if(UserLog.Login(un, pw)!=null) {
			UserLoginDto data = UserLog.Login(un, pw);
			session.setAttribute("InfoUserLogin",data );
			RequestDispatcher rd = request.getRequestDispatcher("HomeForUserController");
			rd.forward(request, response);
			return;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//-------------------------------
		RequestDispatcher rd = request.getRequestDispatcher("WebContent/Auth/IndexAuth.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
