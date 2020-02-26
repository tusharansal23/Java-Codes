<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${username } !
<a href="index.jsp">Logout</a>
<h3>Employee Listings</h3>
<form action="upload">
<input type = "submit" value = "Upload Employee Details" />
<input type = "hidden" value = "${username }" name = "username"/>
</form>
<form action="">
<input type = "submit" value = "Download Employee Details"/>
</form>
 <fieldset>
            <table style="width: 100%">
                <tr>
                    <th>Employee Code</th>
                    <th>Employee Name</th>
                    <th>Location</th>
                    <th>Email</th>
                    <th>Date of Birth</th>
                    <th>Action</th>
                    
                </tr>
  <c:forEach items="${array}" var="arr">
    <tr>
      <td><c:out value="${arr.ecode}" /></td>
      <td><c:out value="${arr.ename}" /></td>
      <td><c:out value="${arr.location}" /></td>
      <td><c:out value="${arr.eid}" /></td>
      <td><c:out value="${arr.dob}" /></td>
      <td>  <form action = "update">
      <input type = "hidden" value = "${username }" name = "username"/>
      <input type = "hidden" value = "${arr.ecode}" name = "eid"/>
      <input type = "submit" value = "Edit"/>
       </form>
       <form action ="delete">
       <input type = "hidden" value = "${username }" name = "username"/>
      <input type = "hidden" value = "${arr.ecode}" name = "eid"/>
      <input type = "submit" value = "delete"/>
       </form></td>
    </tr>
  </c:forEach>

 

                </table>
            </fieldset>

</body>
</html>