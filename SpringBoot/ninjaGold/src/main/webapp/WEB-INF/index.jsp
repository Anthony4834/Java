<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css "href="css/style.css">
	<title>Home</title>
</head>
<body>
	<h3 id="goldLabel">Your gold: <span id="gold"><c:out value="${ gold }" /></span></h3>
	<div id="cardsWrapper">
		<c:forEach items="${ cards }" var="card">
			<section class="card">
				<h3><c:out value="${ card.getName() }" /></h3>
				<h4>Earns <span style="color: ${ card.getMinColor() }"><c:out value="${ card.getMin() }" /></span> - <span style="color: green"><c:out value="${ card.getMax() - 1 }" /></span> gold</h4> <br>
				<form action="/submit" method="post">
					<input type="hidden" name="score" value="${ card.activate() }" />
					<input type="hidden" name="name" value="${ card.getName() }" />
					<input type="submit" value="submit">
				</form>
			</section>
		</c:forEach>
	</div>
	<div id="log">
		<ul>
			<c:forEach items="${ logItems }" var="item">
				<li><c:out value="${ item }"/></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>