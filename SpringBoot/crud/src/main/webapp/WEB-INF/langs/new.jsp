<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Add new</title>
</head>
<body>
	<form:form action="/languages" method="post" modelAttribute="language">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name" /> <br>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator"/>
			<form:input path="creator" /> <br>
		</p>
		<p>
			<form:label path="versionNumber">Latest version</form:label>
			<form:errors path="versionNumber"/>
			<form:input path="versionNumber" /> <br>
		</p>
			<input type="submit" value="add language">
	</form:form>
</body>
</html>