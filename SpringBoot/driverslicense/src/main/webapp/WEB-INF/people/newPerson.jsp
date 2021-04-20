<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel = "stylesheet" type = "text/css" href = "/style.css" />
</head>
<body>
	<h1>Add a person</h1>
	<form:form action="/people/new" method="post" modelAttribute="PERSON">
		<p>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" /> <br>
		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName" /> <br>
		</p>
			<input type="submit" value="add">
	</form:form>
</body>
</html>