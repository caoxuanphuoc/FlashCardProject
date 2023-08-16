package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Card;
import Bean.CollectionCard;
import Bean.Dto.CollectionDetailDto;
import Bo.CardBo;
import Bo.CollectionBo;

/**
 * Servlet implementation class ChangeCardAjax
 */
@WebServlet("/ChangeCardAjax")
public class ChangeCardAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeCardAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		HttpSession session = request.getSession();
		CardBo cardb = new CardBo();
		CollectionBo Colb= new CollectionBo();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String s = (String) request.getParameter("id");
		String IdCollec = (String) request.getParameter("IdCollec");
		String type = (String) request.getParameter("Type");
		
		Long ID = Long.parseLong(IdCollec);
		CollectionCard coll = Colb.Get(ID);
		ArrayList<Card> DSCardByID = cardb.GetAll(ID);
		CollectionDetailDto Collect = new CollectionDetailDto(coll, DSCardByID);
		ArrayList<Card> ds = Collect.getListCard();
		
		int index = Integer.parseInt(s);
		int newindex =0;
		if(type.equals("R")) {
			if( index < ds.size())
				newindex =index+1;
			else
				newindex = index;
		}else {
			if(index == 1 ) {
				newindex = index;
			}else
				newindex = index-1;
		}
		session.setAttribute("CurrentIndex", newindex);
		
		String textHtml="<div class=\"flip-card-inner shadow bg-body rounded\" id=\"card\" onmouseup=\"Flip()\">" +
                "    <div class=\"flip-card-front rounded\">" +
                "        <h2 style=\"padding-top: 25%\">"+ ds.get(newindex-1).getFrontText() +"</h2>" +
                "    </div>" +
                "    <div class=\"flip-card-back shadow rounded\">" +
                "        <h2 style=\"padding-top: 25%\">"+ ds.get(newindex-1).getBackText() +"</h2>" +
                "    </div>" +																				
                "</div>***"
                + " <span onclick=\"change('" + newindex +"','" + IdCollec+ "','L')\"  id=\"bntLeft\" role=\"button\"><i class=\"fa-solid fa-chevron-left bghover rounded-circle p-1  ps-2 pe-2 border\" style=\"font-size: 40px; color: #9b4819;\"></i></span>\r\n"
                + " <span id=\"per\" class=\"text-center fs-4 ps-3 pe-3\" ><span>"+ newindex +"/" +ds.size()+" </span></span>\r\n"
                + "<span  onclick=\"change('" + newindex +"','" + IdCollec+ "','R')\" id=\"bntRight\" role=\"button\"><i class=\"fa-solid fa-chevron-right bghover rounded-circle p-1  ps-2 pe-2 border\" style=\"font-size: 40px; color: #9b4819;\"></i></span>\r\n"
                + "                      ";
		response.getWriter().write(textHtml);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
