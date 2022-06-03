<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="Them" onclick="window.location.href='showFormAdd'">
	<table border="1">
		<tr>
			<th>id</th>
			<th>ten</th>
			<th>don gia</th>
			<th>ma loai</th>
			<th>action</th>
		</tr>

		<tbody>
			<c:forEach var="sp" items="${sanPhams }">
				<c:url var="load" value="loadUpdate">
					<c:param name="productId" value="${sp.id }"></c:param>
				</c:url>
				<c:url var="delete" value="delete">
					<c:param name="productId" value="${sp.id }"></c:param>
				</c:url>
				<tr>
					<td>${sp.id }</td>
					<td>${sp.name }</td>
					<td>${sp.price }</td>
					<td>${sp.id_lsp }</td>
					<td>
						<a href="${load }">update</a>
						<a href="${delete }" onclick="if(!(confirm('Ban co chac muon xoa?'))) return false;">delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>