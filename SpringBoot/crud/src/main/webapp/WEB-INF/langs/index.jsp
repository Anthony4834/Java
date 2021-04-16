<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Home</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Latest Version</th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${ langs }" var="lang">
				<tr>
					<td><c:out value="${ lang.getName() }" /></td>
					<td><c:out value="${ lang.getCreator() }" /></td>
					<td><c:out value="${ lang.getVersionNumber() }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>