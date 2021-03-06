<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<style type="text/css">
html, body {
	display: flex;
	justify-content: center;
}

table, th, td {
	border: 1px solid gray;
}

th {
	padding: 10px 10px;
	background-color: blue;
	color: white;
}

tr {
	padding: 10px 10px;
}

td {
	text-align: center;
}

.btn-add {
	padding: 10px;
	background-color: #408080;
	margin-bottom: 20px;
	border: 1px solid #408080;
	border-radius: 5px;
	color: white;
}
</style>
</head>
<body>
	<div>
		<input type="button" value="Add Customer" class="btn-add"
			onclick="window.location.href='showFormAdd'; return false" />
		<table>
			<tr>
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>

			<c:forEach var="cus" items="${customers}">
				<c:url var="update" value="showUpdate">
					<c:param name="id" value="${cus.id}"></c:param>
				</c:url>

				<c:url var="del" value="delete">
					<c:param name="id" value="${cus.id}"></c:param>
				</c:url>
				<tr>
					<td>${cus.id}</td>
					<td>${cus.firstName}</td>
					<td>${cus.lastName}</td>
					<td>${cus.email}</td>
					<td><a href="${update}">Update</a> <a href="${del}"
						onclick="if(!(confirm('Xoa?'))) return false;">Delete</a></td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>