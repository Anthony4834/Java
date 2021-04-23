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
    <script src="/js/loginReg.js" type="text/javascript"></script>
</head>
<body>
	<img class="cloud" id="cloudImg" src="/img/cloud.png" height= "100px" width="150px">
	<img class="cloud" id="cloudImg2" src="/img/cloud.png" height="50px" width="120px">
	<img class="cloud" id="cloudImg3" src="/img/cloud.png" width="120px">
	<img class="cloud" id="cloudImg4" src="/img/cloud.png" width="170px">
	<img class="cloud" id="cloudImg5" src="/img/cloud.png" width="130px">
	
    <img id="bgImg" src="/img/bluebg_img.png" width = 623px/>
    <div id="registerBox">
    	<h1>Welcome back!</h1>
    	<p id="err"><c:out value="${ error }"/></p>
    	<p>To stay connected with us, please login down below with your <br>
    	 personal email and password. <br>
    	<form:form method="POST" action="/login">
    		<input type="hidden" name="remember" value=false id="hiddenRemember" />
	    	<section class="inputWrapper" id="emailWrapper">
	    		<img class="bigImg" src="/img/email.png" />
		    	<p>
		            <label for="email">Email</label> <br>
		            <input type="text" name="email" id="email"/>
		            <img class="verif-icon" id="emailCheck" src="/img/x.png">
		        </p>
	    	</section>
	    	<section class="inputWrapper" id="passWrapper">
	    		<img class="bigImg" src="/img/pass.png" />
		        <p>
		            <label for="password">Password</label> <br>
		            <input type="password" name="password" id="pass"/>
		            <img class="verif-icon" id="passCheck" src="/img/x.png">
		        </p>
	         </section>
		     	<label class="container">Remember me
				  <input type="checkbox" id="remember">
				  <span class="checkmark"></span>
				</label>
	         <input type="submit" value="Login!" id="reg" disabled/>
			 <button id="login" type="button">Need an account? Register now</button>
    	</form:form>
    </div>
    
</body>
</html>
