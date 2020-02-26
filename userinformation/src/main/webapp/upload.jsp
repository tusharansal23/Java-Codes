<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${username } !
<a href = "index.jsp">Logout</a>
<h3>Upload Employye Details</h3>
<form action="create">
Employee Code : <input type = "text" name = "ecode" required/><br>
Employee Name : <input type = "text" name = "ename" required/><br>
Location : <input type = "text" name = "location" required/><br>
Email : <input type = "email" name = "email"><br>
Date of Birth : <input type = "text" name = "edate"><br>
<input type = "submit" value = "upload">
<input type = "submit" value = "cancel">
</form>
</body>
</html>