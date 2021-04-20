<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${ person.getFirstName() }" /></title>
	<link rel = "stylesheet" type = "text/css" href = "/style.css" />
</head>
<body>
	<h1><c:out value ="${ person.getFirstName() }" /> <c:out value ="${ person.getLastName() }" /></h1>
	<h5>License number: </h5><p><c:out value ="${ license.getNumber() }" /></p>
	<h5>State: </h5><p><c:out value ="${ license.getState() }" /></p>
	<h5>Expiration date: </h5><p><c:out value ="${ license.getExpiry() }" /></p>
</body>
</html>