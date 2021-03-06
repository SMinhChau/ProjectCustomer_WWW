<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<table>
		<form:form action="saveProduct" modelAttribute="sanPham" method="POST">
			<form:hidden path="id" />
			<tr>
				<td>Ten san pham:</td>
				<td><form:input path="name" value="${sanPham.name }"></form:input></td>
				<td><form:errors path="name" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Gia:</td>
				<td><form:input path="price" value="${sanPham.price }"></form:input></td>
				<c:if test="${price != null }">
					<td class="error">Gia > 0</td>
				</c:if>
			</tr>

			<tr>
				<td>Loai san pham:</td>
				<td><form:select path="id_lsp">
						<form:option value="0">Chon loai san pham</form:option>
						<c:forEach var="lsp" items="${loaiSPs}">
							<form:option value="${lsp.id }">${lsp.name }</form:option>
						</c:forEach>
					</form:select></td>
				<c:if test="${status != null }">
					<td class="error">Chon lon chon lai!</td>
				</c:if>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Gui"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>