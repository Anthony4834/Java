<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/time.css">
    <script type="text/javascript" src="js/time.js"></script>
	<meta charset="ISO-8859-1">
	<title>Home Page</title>
</head>
<body>
	<h1 style="text-align: center">
		<fmt:formatDate dateStyle="long" type = "time" value = "${ date }" pattern="HH:MM a" />
	</h1>
</body>
</html>