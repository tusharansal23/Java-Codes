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
<h3>Edit Employye Details</h3>
<form action="updates">
Employee Code : <input type = "text" name = "ecode" value = "${ecode}" required/><br>
Employee Name : <input type = "text" name = "ename" value = "${ename}" required/><br>
Location : <input type = "text" name = "location" value = "${location} "required/><br>
Email : <input type = "email" name = "email" value = "${eid}"><br>
Date of Birth : <input type = "text" name = "edate" value = "${dob}"><br>
<input type = "submit" value = "edit">
<input type = "submit" value = "cancel">
</form>
</body>
</html>