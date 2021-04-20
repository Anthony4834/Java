<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New License</title>
	<link rel = "stylesheet" type = "text/css" href = "/style.css" />
</head>
<body>
	<h1>Add a license</h1>
	<form:form action="/license/new" method="post" modelAttribute="LICENSE">
		<p>
			<form:label path="person">Person</form:label>
			<form:select path="person">
				<c:forEach items = "${ people }" var = "p">
					<form:option value = "${ p }">
						<c:out value = "${ p.getFirstName() }" />
					</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:input path="state" /> <br>
		</p>
		<p>
			<form:label path="expiry">Expiration Date</form:label>
			<form:errors path="expiry"/>
			<form:input type = "date" path="expiry" /> <br>
		</p>
			<input type="submit" value="add">
	</form:form>
</body>
</html>