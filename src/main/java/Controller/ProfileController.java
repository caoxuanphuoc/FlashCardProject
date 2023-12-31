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
import javax.websocket.Session;

import Bean.Dto.FamousRateViewDto;
import Bean.Dto.UserLoginDto;
import Bean.Dto.CollectionDtos.Collectiondto;
import Bo.CollectionBo;
import Bo.UserBo;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//-----------init Struct
		HttpSession session = request.getSession();
		CollectionBo ColecBo = new CollectionBo();
		UserBo UBo = new UserBo();
		
		//------------Check-login------------
		UserLoginDto info = (UserLoginDto) session.getAttribute("InfoUserLogin");
		if(info == null) {
			RequestDispatcher rd = request.getRequestDispatcher("LoginController");
			rd.forward(request, response);
		}
		
		//---------------Get All Collection--------------
		ArrayList<Collectiondto> dsCo = ColecBo.GetAllByUser(info.getUserId());
		session.setAttribute("CollectionByProfile", dsCo);
		
		//----------------Get Rate Famous
		String IdU = (String) request.getParameter("RateId");
		FamousRateViewDto Rate = new FamousRateViewDto();
		if(IdU==null)
			Rate = UBo.GetFamousRate(info.getUserId());
		else 
			Rate = UBo.GetFamousRate(Long.parseLong(IdU));
		session.setAttribute("FamousRate", Rate);
		
		
		
		//----------------------------------------------------------------\\
		RequestDispatcher rd = request.getRequestDispatcher("WebContent/Profile.jsp");
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
