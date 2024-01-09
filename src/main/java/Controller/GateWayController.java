package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GateWayController
 */
@WebServlet("/GateWayController")
public class GateWayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GateWayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--HomeforUser
		System.out.println("Gate running");
		String G1 = (String) request.getParameter("Gate");
		if(G1 !=null) {
			switch (G1) {
			case "OK": {
				RequestDispatcher rd = request.getRequestDispatcher("HomeForUserController");
				rd.forward(request, response);
				break;
			}
			case "ADD_COLLECTION":{
				RequestDispatcher rd = request.getRequestDispatcher("CollectionCardController");
				rd.forward(request, response);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + G1);
			};
			//ngon
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
