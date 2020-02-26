<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    message
        <h2>${message}</h2>
        <% getServletContext().getRequestDispatcher("/Image.jsp").forward(
	                request, response);
        %>
</body>
</html>