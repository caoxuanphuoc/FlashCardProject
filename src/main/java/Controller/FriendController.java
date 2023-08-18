package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.FriendBo;

/**
 * Servlet implementation class FriendController
 */
@WebServlet("/FriendController")
public class FriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		
		//------------INIT
		FriendBo FBo = new FriendBo();
		
		String UserIdS = request.getParameter("UserId");
		String FriendIdS = request.getParameter("FriendId");
		
		if( UserIdS !=null && FriendIdS !=null) {
			Long UserId = Long.parseLong(UserIdS);
			Long FriendId = Long.parseLong(FriendIdS);
			if(FBo.IsFollow(UserId, FriendId)) {
				response.getWriter().write("exist");
			}else {
				FBo.CreateFollow(UserId, FriendId);
				response.getWriter().write("OK");
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace()	;
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
