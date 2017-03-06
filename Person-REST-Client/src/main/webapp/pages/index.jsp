<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Spring MVC web app!</title>
</head>
<body>
	<h1 style="color: green;">Welcome to SpringMVC!</h1>

	<table border="5">
		<TR>
			<th>Person ID</th>
			<th>Person Firstname</th>
			<th>Person Lastname</th>
			<th>Person Age</th>
			<th>
				<div>Actions</div>
			</th>
		</TR>
		<c:forEach var="person" items="${Persons}">
			<tr>
				<TD>${person.id}</TD>
				<TD>${person.firstname}</TD>
				<TD>${person.lastname}</TD>
				<TD>${person.age}</TD>
				<td>
					<div>
						<a href="edit?id=${person.id}&firstname=${person.firstname}&lastname=${person.lastname}&age=${person.age}"><img alt="edit" src="pages/images/edit_icon_15.png" border="0"></a>
						<a href="delete?id=${person.id}"><img alt="delete"
							src="pages/images/delete_icon_15.png" border="0"> </a>
					</div>
				</td>

			</tr>
		</c:forEach>
	</table>
	<div>
		<p>
			Add new Person <a href="edit"><img alt="add"
				src="pages/images/add_icon_15.png" border="0"></a>
		</p>
	</div>
</body>
</html>