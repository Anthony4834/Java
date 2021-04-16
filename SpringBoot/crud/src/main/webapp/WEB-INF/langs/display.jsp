<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title><c:out value="${ lang.getName() }" /></title>
</head>
<body>
	<h1><c:out value="${ lang.getName() }" /></h1>
	<p>Creator: <c:out value="${ lang.getCreator() }" /></p>
	<p>Version number: <c:out value="${ lang.getVersionNumber() }" /></p>
</body>
</html>