package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.Card;
import Bean.CollectionCard;
import Bean.Dto.CollectionDetailDto;
import Bo.CardBo;
import Bo.CollectionBo;

/**
 * Servlet implementation class CollectionEditController
 */
@WebServlet("/CollectionEditController")
public class CollectionEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		
		//-------------init everything
		HttpSession session = request.getSession();
		CollectionBo Colb = new CollectionBo();
		CardBo cardb = new CardBo();
		
		//--------------Get-Collection-dto- form collecton detail
		String IDString = request.getParameter("IdCOllection");
		if(IDString!=null) {
			Long Id = Long.parseLong(IDString);
			CollectionCard coll = Colb.Get(Id);
			ArrayList<Card> DSCardByID = cardb.GetAll(Id);
			CollectionDetailDto Dto = new CollectionDetailDto(coll, DSCardByID);
			session.setAttribute("CollectionForEdit", Dto);
		}
		
		
		//----------------DELETE COLLECTON-IdCOllectionDelete
		String IdStringd = (String) request.getParameter("IdCOllectionDelete");
		if(IdStringd!=null) {			
		Long idcolectDele = Long.parseLong(IdStringd);
		Colb.Delete(idcolectDele);
		RequestDispatcher rd = request.getRequestDispatcher("CollectionCardController");
		rd.forward(request, response);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WebContent/CollectionCardEdit.jsp");
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
