<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page
	import="com.nagarro.dao.HibernateUtil,org.hibernate.Session,com.nagarro.model.*,java.util.List"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Image</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if (session.getAttribute("username") == null) {
			out.println("hey");
			response.sendRedirect("Login.jsp");
		}
	%>
	<center>
		<h3>Image Management Utility</h3>
	</center>
	<form action="upload" method="post" enctype="multipart/form-data">
		Please select an image file to upload(Max Size 1 MB) <input
			type="file" name="file" /> <input type="submit" name="submit"
			value="submit" />
	</form>
	<h2>Uploaded Images</h2>
	<fieldset>
		<table style="width: 100%">

			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Size</th>
				<th>Display</th>
				<th>Action</th>
			</tr>

			<%
				String uname = (String) session.getAttribute("username");
					Session sc = HibernateUtil.getSession();
					sc.beginTransaction();
					User u = sc.get(User.class, uname);
					List<Image> images = u.getImage();
					int i = 0;
					for (Image image : images) {
						out.println("<tr><td>");
						out.println((++i) + "</td>");
						out.println("<td>");
						out.println(image.getFileName() + "</td>");
						out.println("<td>");
						out.println(image.getSize() + " KB" + "</td>");
						out.println("<td><img src='" + image.getFileUrl() + "' width='100' height='100'/></td>");
						out.println("<td><a href=\"update?imageId=" + image.getId() + "\">" + "update"
								+ "</a><br><a href=\"delete?imageId=" + image.getId() + "\">" + "delete"
								+ "</a><br><a href=\"updateurl?imageId=" + image.getId() + "\">" + "updateUrl" + "</a></td>");

						// 		session.setAttribute("id", image.getId());
						//           out.println("<td>");
						//           out.println("<form action = 'delete' method = 'post'>");
						//           out.println("<input type = 'submit' name = 'submit' value = 'delete'/>");
						//           out.println("</form>");
						//           out.println("<form action = 'update.jsp' method = 'post'>");
						//           out.println("<input type = 'submit' name = 'submit' value = 'update'/>");
						//           out.println("</form></td>");

						out.println("</tr>");
					}
			%>
		</table>
	</fieldset>
</body>
</html>