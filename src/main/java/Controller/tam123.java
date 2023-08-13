package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class tam123
 */
@WebServlet("/tam123")
public class tam123 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tam123() {
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
			List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
			//duyệt qua các đối tượng gửi lên từ client gồm file và các control
for (FileItem fileItem : fileItems) {
		System.out.println("==========="+ fileItem.getFieldName());
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
				              System.out.println("UPLOAD THÀNH CÔNG...!" +fileImg);
				 } catch (Exception e) {
				    e.printStackTrace();
				}
			}
		 }
			else//Neu la control
			{
				String tentk=fileItem.getFieldName();
				if(tentk.equals("txthoten"))
					response.getWriter().println(fileItem.getString());
				if(tentk.equals("txtdiachi"))
					response.getWriter().println(fileItem.getString());
				System.out.println(fileItem.getString());
			}
			}
		
		} catch (FileUploadException e) {
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
