<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/style.css" />
</head>
<body>
	<h1>Add a ninja</h1>
	<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
		<form:label path="dojo">Dojo</form:label>
		<form:select path="dojo">
			<c:forEach items = "${ dojos }" var = "d">
				<form:option value = "${ d }">
					<c:out value = "${ d.getName() }" />
					<c:out value = "${ d.getId() }" />
				</form:option>
			</c:forEach>
		</form:select> <br>
		
		<form:label path="firstName">First Name</form:label>
		<form:input path="firstName" value="Anthony" /> <br>
		
		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" value="Griffin"/> <br>
		
		<form:label path="age">Age</form:label>
		<form:input type="number" path="age" value="20"/> <br>
		
		<input type="submit" value="submit">
	</form:form>
</body>
</html>