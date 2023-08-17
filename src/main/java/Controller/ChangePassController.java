package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.UserBo;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePassController")
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassController() {
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
			String UserId = (String) request.getParameter("UserId");
			String Password =(String) request.getParameter("Password");
			String NewPass =(String) request.getParameter("NewPass");
			UserBo ubo = new UserBo();
			String EnPass = ubo.ecrypt(Password);
			String EnNewPass = ubo.ecrypt(NewPass);
			Long IdUserL = Long.parseLong(UserId);
			if(ubo.changePass(IdUserL, EnPass, EnNewPass) ==1) {
				response.getWriter().write("OK");
			}else {
				response.getWriter().write("Mật khẩu không đúng");
			}
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
