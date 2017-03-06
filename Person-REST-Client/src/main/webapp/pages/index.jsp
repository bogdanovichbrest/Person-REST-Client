<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person-REST-Client</title>
</head>
<body>
<h1>Welcome to Spring-MVC</h1>
<table>
<tr>
<th>ID</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Age</th>
<th>Actions</th>
</tr>

<c:forEach var = "person" items="${persons}">
<tr>
<td>${person.id}</td>
<td>${person.firstname}</td>
<td>${person.lastname}</td>
<td>${person.age}</td>
<td></td>
</tr>
</c:forEach>

</table>
</body>
</html>