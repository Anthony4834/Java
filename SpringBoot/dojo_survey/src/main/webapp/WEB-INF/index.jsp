<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<meta charset="ISO-8859-1">
	<title>Home Page</title>
</head>
<body>
	<h1>Welcome user</h1> <br>
	<form action="/submit" method="POST">
		<p style="color: red"><c:out value="${error}" /></p> <br>
		<label for="name">Name:</label>
		<input type="text" id="name" name="name" required> <br>
		<label for="location">Dojo location</label>
		<select id="location" name="location">
			<option>San Jose</option>
			<option>Seattle</option>
			<option>Other</option>
		</select> <br>
		<label for="language">Favorite Language</label>
		<select id="language" name="language">
			<option>Python</option>
			<option>JavaScript</option>
			<option>Java</option>
			<option>Other</option>
		</select> <br>
		<label for="comment">Comments: (Optional)</label>
		<textarea id="comment" name="comment"></textarea> <br>
		<section id="submitWrapper"><input type="submit" value="Submit"></section>
	</form>
</body>
</html>