<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
	<h1><c:out value="${ category.getName() }"/></h1>
	<form:form action="/category/${ category.getId() }" method="POST">
		<input type="hidden" name="_method" value="put">
		<ul>
			<c:forEach items="${ products }" var="product">
				<li><c:out value="${ product.getName() }" /></li>
			</c:forEach>
		</ul>
		<select name="product" id="product">
			<option value=null selected disabled>--select--</option>
			<c:forEach items="${ potentialProducts }" var="p">
				<option value="${ p.getId() }"><c:out value="${ p.getName() }"/></option>
			</c:forEach>
		</select>
		<input type="submit" value="Add"/>
	</form:form>
</body>
</html>