package com.nagarro.update;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;

import com.nagarro.dao.HibernateUtil;
import com.nagarro.model.Image;

@WebServlet(name = "updateurl", urlPatterns = { "/updateurl" })
public class UpdateUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "upload";
	int id;
	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1;
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("imageId");
		id = Integer.parseInt(s);
		System.out.println(id);
		getServletContext().getRequestDispatcher("/updateUrl.jsp").forward(
                request, response);    
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		// this path is relative to application's directory
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			System.out.println("1" + uploadPath);
			// parses the request's content to extract file data
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// iterates over form's fields
				for (FileItem item : formItems) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
//	                        System.out.println("2"+fileName);
//	                        String filePath = uploadPath +File.separator+ fileName;
						String filePath = getServletContext().getRealPath("") + "\\upload\\" + fileName;
						System.out.println("@@@@" + filePath);
						File storeFile = new File(filePath);
						if (storeFile.length() / (1024 * 1024) > 1) {
							PrintWriter out = response.getWriter();
							out.println("Image size is more than 1 MB");
							getServletContext().getRequestDispatcher("/Image.jsp").forward(request, response);

						}

						// saves the file on disk
						item.write(storeFile);
						String name = storeFile.getName();
//				        String fileUrl = file.getPath();
						String fileUrl = "upload\\" + name;
						Session se = HibernateUtil.getSession();
		    			se.beginTransaction();
		    			Image image = se.get(Image.class, id);
		    			//image.setFileUrl(fileUrl);
		    		    se.getTransaction().commit();					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("message", "There was an error: " + ex.getMessage());
		}

		getServletContext().getRequestDispatcher("/Image.jsp").forward(request, response);
	}

}
