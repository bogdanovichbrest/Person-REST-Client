<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit Person</title>
</head>
<body>
	<h1>Add/Edit Person</h1>
	<table border="5">
		<TR>
			<th>Person ID</th>
			<th>Person Firstname</th>
			<th>Person Lastname</th>
			<th>Person Age</th>
			<th>
				<div>Action</div>
			</th>
		</TR>
			<tr>
			<form action="save" method="${method}">
				<TD><input name="id" type="text" value="${person.id}" readonly="readonly"></TD>
				<TD><input name="firstname" type="text" value="${person.firstname}"></TD>
				<TD><input name="lastname" type="text" value="${person.lastname}"></TD>
				<TD><input name="age" type="text" value="${person.age}"></TD>
				<td>
					<div>
						<input type="image"  alt="save"
							src="pages/images/save_icon_15.png" border="0">
					</div>
				</td>
</form>
			</tr>
	</table>

</body>
</html>