package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.Card;
import Bo.CardBo;
import Bo.CollectionBo;

/**
 * Servlet implementation class AddCardController
 */
@WebServlet("/AddCardController")
public class AddCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
//		 String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "files";
//		 response.getWriter().println(dirUrl1);
		 
		try {
			String meth = (String) request.getParameter("meth");
			String IdCoS = (String) request.getParameter("idc");
			
			List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
			//duyệt qua các đối tượng gửi lên từ client gồm file và các control
			
			 Long CollectionId = Long.parseLong(IdCoS);
			 String FrontText  = "";
			 String BackText = "";
			 String ImgFront = "";
			 String ImgBack = "";
			 Boolean IsDelete = true;

for (FileItem fileItem : fileItems) {
			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
				// xử lý file
				String nameimg = fileItem.getName();
				if (!nameimg.equals("")) {
					String custom = "C:\\Users\\Admin\\Desktop\\KY_1_NAM_4\\java\\FlashCardEduProject\\src\\main\\webapp\\Public\\ImgUpload";
					File dir = new File(custom);
					if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
						dir.mkdir();
					}
				           String fileImg = custom + File.separator + nameimg;
				          File file = new File(fileImg);//tạo file
				            try {
				               fileItem.write(file);//lưu file
				               ImgBack = "Public/ImgUpload/" +nameimg;
				              System.out.println("UPLOAD THÀNH CÔNG...!" +fileImg);
				 } catch (Exception e) {
				    e.printStackTrace();
				}
			}
		 }
			else//Neu la control
			{
				String Name=fileItem.getFieldName();
				if(Name.equals("ThuatNgu"))
					FrontText = fileItem.getString();
				if(Name.equals("DinhNghia"))
					BackText = fileItem.getString();
			}
			}
		System.out.println("tham so: "+ meth);
		System.out.println("thuat ngu" + FrontText +" dinh nghia "+ BackText +" src " + ImgBack);
		CardBo cbo = new CardBo();
	
			if(meth.equals("add")) {				
			if(CollectionId !=null && FrontText !=null && BackText !=null && ImgFront !=null && ImgBack !=null)
				{
				cbo.Create(CollectionId, FrontText, BackText, ImgFront, ImgBack);
				}
			}else  {		
				System.out.println("check method 1 OK ");
				CardBo Carb = new CardBo();
				Long idUpdate = Long.parseLong(meth);
				System.out.println("check method 2: OK");
				Card cur = Carb.GetById(idUpdate);
				cur.setCollectionId(CollectionId);
				cur.setFrontText(FrontText);
				cur.setBackText(BackText);
				cur.setImgBack(ImgBack);
				Carb.Update(cur);
			}
		
		response.sendRedirect("idUpdate");
		
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
