<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/style.css" />
</head>
<body>
	<h1><c:out value="${ dojo.getName() }" /></h1>
	<table>
		<thead id="head">
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ ninjas }" var="n">
				<tr>
					<td><c:out value="${ n.getFirstName() }"/></td>
					<td><c:out value="${ n.getLastName() }"/></td>
					<td><c:out value="${ n.getAge() }"/></td>
				</tr>
			</c:forEach>
					
		</tbody>
	</table>
	
</body>
</html>