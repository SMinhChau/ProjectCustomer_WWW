<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Customer</title>
<style type="text/css">
html, body {
	display: flex;
	justify-content: center;
}

table {
	padding-top: 20px;
}

th {
	border: 1px solid gray;
	padding: 10px 10px;
	background-color: blue;
	color: white;
}

.errors {
	color: red;
	font-style: italic;
}
.btn-add {
	padding: 10px;
	background-color: #408080;
	margin-left: 150px;
	border: 1px solid #408080;
	border-radius: 5px;
	color: white;
}
input[type=text] {
	width: 200px;
	height: 25px;
}
</style>
</head>
<body>
	<div>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" value="${customer.firstName}" />
					</td>
					<td><form:errors path="firstName" class="errors"></form:errors>
					</td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" value="${customer.lastName}" />
					</td>
					<td><form:errors path="lastName" class="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" value="${customer.email}" /></td>
					<td><form:errors path="email" class="errors"></form:errors></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save" class="btn-add" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>