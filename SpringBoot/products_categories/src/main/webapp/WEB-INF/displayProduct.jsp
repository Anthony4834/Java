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
	<h1><c:out value="${ product.getName() }"/></h1>
	<form:form action="/product/${ product.getId() }" method="POST">
		<input type="hidden" name="_method" value="put">
		<ul>
			<c:forEach items="${ categories }" var="cat">
				<li><c:out value="${ cat.getName() }" /></li>
			</c:forEach>
		</ul>
		<select name="cat" id="cat">
			<option value=null selected disabled>--select--</option>
			<c:forEach items="${ potentialCats }" var="c">
				<option value="${ c.getId() }"><c:out value="${ c.getName() }"/></option>
			</c:forEach>
		</select>
		<input type="submit" value="Add"/>
	</form:form>
</body>
</html>