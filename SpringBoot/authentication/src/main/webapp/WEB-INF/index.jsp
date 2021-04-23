<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="/css/style2.css"/>
    <link rel="stylesheet" type="text/css" href="/css/checkmark.css"/>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="/js/index.js" type="text/javascript"></script>
</head>
<body>
	<img class="cloud" id="cloudImg" src="/img/cloud.png" height= "100px" width="150px">
	<img class="cloud" id="cloudImg2" src="/img/cloud.png" height="50px" width="120px">
	<img class="cloud" id="cloudImg3" src="/img/cloud.png" width="120px">
	<img class="cloud" id="cloudImg4" src="/img/cloud.png" width="170px">
	<img class="cloud" id="cloudImg5" src="/img/cloud.png" width="130px">
	
    <img id="bgImg" src="/img/bluebg_img.png" width = 623px/>
    <div id="registerBox">
    	<p id="err"><c:out value="${ error }"/></p>
    	<p>made it here, stay a while</p>
    	<c:out value="${ user.getEmail() }" />
    	<button id="logout">Logout</button>
    </div>
    
</body>
</html>
