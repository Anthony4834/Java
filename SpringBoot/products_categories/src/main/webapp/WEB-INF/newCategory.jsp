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
	<h1>Add a category</h1>
	<form:form action="/categories/new" method="POST" modelAttribute="category">
		<form:label path="name">Name</form:label>
		<form:input path="name"/> <br>
		<input type="submit" value="Add"/>
	</form:form>
</body>
</html>