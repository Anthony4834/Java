<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/time.css">
	<meta charset="ISO-8859-1">
	<title>Home Page</title>
</head>
<body>
	<h1>Welcome user</h1>
	<form action="/api/submit" method="POST">
		<p style="color: red"><c:out value="${error}" /></p> <br>
		<label for="code">Enter code here:</label>
		<input type="text" id="code" name="code" required>
	</form>
</body>
</html>