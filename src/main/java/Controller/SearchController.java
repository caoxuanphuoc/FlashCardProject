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

import Bean.Dto.CollectionDtos.Collectiondto;
import Bo.CollectionBo;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		//-------------INIT
		HttpSession session = request.getSession();
		CollectionBo CoBo = new CollectionBo();
		
		//--------------Search---------------
		String KeyWord = (String) request.getParameter("KeyWord");
		if(KeyWord!=null) {
			ArrayList<Collectiondto> res = CoBo.Search(KeyWord);
			session.setAttribute("KeyWord", KeyWord);
			session.setAttribute("ResultSearch", res);
		}
		
		//----------------Show Pre view-----------------
		String idcollect = (String) request.getParameter("ShowPreViewId");
		if(idcollect!=null) {
			Long Id = Long.parseLong(idcollect);
			session.setAttribute("ShowCollect", CoBo.GetColectDetailById(Id));
		}else {
			ArrayList<Collectiondto> res = CoBo.Search(KeyWord);
			if(res.size()>0) {
				Long IdFirstColection = res.get(0).getId();
			session.setAttribute("ShowCollect", CoBo.GetColectDetailById(IdFirstColection));
			}
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WebContent/SearchPage.jsp");
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
