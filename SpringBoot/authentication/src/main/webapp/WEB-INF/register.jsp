<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/css/checkmark.css"/>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="/js/index.js" type="text/javascript"></script>
    <script src="/js/loginReg.js" type="text/javascript"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
</head>
<body>
	<img class="cloud" id="cloudImg" src="/img/cloud.png" height= "100px" width="150px">
	<img class="cloud" id="cloudImg2" src="/img/cloud.png" height="50px" width="120px">
	<img class="cloud" id="cloudImg3" src="/img/cloud.png" width="120px">
	<img class="cloud" id="cloudImg4" src="/img/cloud.png" width="170px">
	<img class="cloud" id="cloudImg5" src="/img/cloud.png" width="130px">
	
    <img id="bgImg" src="/img/bg_image.jpg"/>
    <div id="registerBox">
    	<h1>Welcome! Register here</h1>
    	<p id="err"><c:out value="${ error }"/></p>
    	<p>To stay connected with us, please register down below with your <br>
    	 personal email and password. <br><br> It's secure and only takes a few steps.</p>
    	<form:form method="POST" action="/register" modelAttribute="user">
    		<input type="hidden" name="remember" value=false id="hiddenRemember" />
	    	<section class="inputWrapper" id="emailWrapper">
	    		<img class="bigImg" src="/img/email.png" />
		    	<p>
		            <form:label path="email">Email</form:label> <br>
		            <form:input type="email" path="email" id="email"/>
		            <img class="verif-icon" id="emailCheck" src="/img/x.png">
		        </p>
	    	</section>
	    	<section class="inputWrapper" id="passWrapper">
	    		<img class="bigImg" src="/img/pass.png" />
		        <p>
		            <form:label path="password">Password</form:label> <br>
		            <form:password path="password" id="pass"/>
		            <img class="verif-icon" id="passCheck" src="/img/x.png">
		        </p>
	         </section>
		     <section class="inputWrapper" id="passConfWrapper">
		     	<img class="bigImg" src="/img/confpass.png" />
		   		<p>
		            <form:label path="passwordConfirmation">Confirm Password</form:label> <br>
		            <form:password path="passwordConfirmation" id="passConf"/>
		            <img class="verif-icon" id="passConfCheck" src="/img/x.png">
		        </p>
		     </section>
		     	<label class="container">Remember me
				  <input type="checkbox" id="remember">
				  <span class="checkmark"></span>
				</label>
	         <input type="submit" value="Register!" id="reg" disabled/>
	         <button id="login" type="button" onclick="prevent">Have an account? Login instead</button>
    	</form:form>
    </div>
    
</body>
</html>
