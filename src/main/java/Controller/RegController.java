package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.User;
import Bean.Dto.UserLoginDto;
import Bo.UserBo;

/**
 * Servlet implementation class RegController
 */
@WebServlet("/RegController")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		String username = 	(String) request.getParameter("username");
		String email=	(String)request.getParameter("email");
		String password1=	(String)request.getParameter("password1");
		String password2=	(String)request.getParameter("password2");
		UserBo Ubo = new UserBo();
		String TextRespone ="";
		
		boolean OK=true;
		//check Un
		if( username.equals("")==false && Ubo.UserNameOk(username) )
			TextRespone = TextRespone + "***username- ";
		else {
			TextRespone = TextRespone + "***username-UserName đã tồn tại";
			OK= false;
		}
		// check email
		if(email.equals("")==false && Ubo.UserNameOk(email))
			TextRespone = TextRespone + "***email- ";
		else {
			TextRespone = TextRespone + "***email-Email đã tồn tại";
			OK= false;
		}
		//---check pass
		if(password1.equals("")==false && password2.equals("")==false && password1.equals(password2))
			TextRespone = TextRespone + "***password2- ";
		else {			
			TextRespone = TextRespone + "***password2-Mật khẩu không khớp";
			OK= false;
		}
		if(OK) {
			TextRespone = "Success"+ TextRespone;
			String MD5Pass = Ubo.ecrypt(password2);
			User info = new User(username, MD5Pass, email);
			Ubo.CreateUser(info);
			UserLoginDto data = Ubo.Login(username, MD5Pass);
			session.setAttribute("InfoUserLogin",data );
			//response.sendRedirect("");
		}
		else {
			TextRespone = "Error"+ TextRespone;			
		}
		
		response.getWriter().write(TextRespone);
		
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
