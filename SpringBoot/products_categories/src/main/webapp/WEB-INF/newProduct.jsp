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
	<h1>Add a product</h1>
	<form:form action="/products/new" method="POST" modelAttribute="product">
		<form:label path="name">Name</form:label>
		<form:input path="name"/> <br>
		<form:label path="description">Description</form:label>
		<form:input path="description"/> <br>
		<form:label path="price">Price</form:label>
		<form:input path="price" type="number" step="0.01"/> <br>
		<input type="submit" value="Add"/>
	</form:form>
</body>
</html>