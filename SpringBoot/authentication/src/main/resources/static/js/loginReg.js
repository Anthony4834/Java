$(document).ready(function() {
	var emailCheck = null;
	var passCheck = null;
	var passConfCheck = null;
	var emailRegex = /^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$/;
	
	$("#pass").focus();
	setTimeout(function() {
		$("#email").focus();
	}, 10)
	
	const runValidations = () => {
		if($("#login")[0].innerHTML != "Need an account? Register now") {
			if(emailCheck && passCheck && passConfCheck) {
				$("#reg").attr("disabled", false);
				return false;
			} else {
				$("#reg").attr("disabled", true);
				return true;
			}
		} else {
			if(emailCheck && passCheck) {
				$("#reg").attr("disabled", false);
				return false;
			} else {
				$("#reg").attr("disabled", true);
				return true;
			}
		}
	}
	$(".inputWrapper").click(function() {
		console.log($(this).children("p").eq(0).children("input").eq(0));
		$(this).children("p").eq(0).children("input").eq(0).focus();
	})
	$("#email").ready(function() {
		if($("#login")[0].innerHTML == "Need an account? Register now") {
			let email = window.localStorage.getItem("rememberedEmail");
			if(email) {
				$("#email").prop("value", email);
				setTimeout(function() {
					emailCheck = true;
					$("#remember").prop("checked", "checked");
					$("#emailCheck").css("opacity", "1");
					$("#emailCheck").attr("src", "/img/check.png");
					$("#pass").focus()
				}, 50)
			}
		}
	})
	$("#email").keyup(function() {
		if($("#email").val().length > 0) {
			$("#emailCheck").css("opacity", "1");
		}
		if(!$("#email").val().match(emailRegex)) {
			$("#emailCheck").attr("src", "/img/x.png");
			emailCheck = false;
		} else {
			$("#emailCheck").attr("src", "/img/check.png");
			emailCheck = true;
		}
		runValidations();
	})
	$("#email").blur(function() {
		runValidations();
		if(emailCheck) {
			$("#emailWrapper").css("filter", "brightness(90%)");
		}
	})
	$("#email").focus(function() {
		$("#emailWrapper").css("filter", "brightness(100%)");
	})
	$("#pass").keyup(function() {
		if($("#pass").val().length > 0) {
			$("#passCheck").css("opacity", "1");
		}
		if($("#pass").val().length < 8) {
			$("#passCheck").attr("src", "/img/x.png");
			passCheck = false;
		} else {
			$("#passCheck").attr("src", "/img/check.png");
			passCheck = true;
		}
		//check confirm
		if($("#passConf").val() != $("#pass").val()) {
	        $("#passConfCheck").attr("src", "/img/x.png");
	        passConfCheck = false;
	    } else {
	        $("#passConfCheck").attr("src", "/img/check.png");
	        passConfCheck = true;
	    }
		runValidations();
	})
	$("#pass").blur(function() {
		if(passCheck) {
			$("#passWrapper").css("filter", "brightness(90%)");
		}
	})
	$("#pass").focus(function() {
		$("#passWrapper").css("filter", "brightness(100%)");
	})
	$("#passConf").keyup(function() {
	    if($("#passConf").val().length > 0) {
			$("#passConfCheck").css("opacity", "1");
		}
	    if($("#passConf").val() != $("#pass").val() || $("#passConf").val().length == 0) {
	        $("#passConfCheck").attr("src", "/img/x.png");
	        passConfCheck = false;
	    } else {
	        $("#passConfCheck").attr("src", "/img/check.png");
	        passConfCheck = true;
	    }
	    runValidations();
	})
	$("#passConf").blur(function() {
	    if(passConfCheck) {
	        $("#passConfWrapper").css("filter", "brightness(90%)");
	    }
	})
	$("#passConf").focus(function() {
	    $("#passConfWrapper").css("filter", "brightness(100%)");
	})
	$("#hiddenRemember").ready(function() {
		if(window.localStorage.getItem("rememberedEmail")) {
			$("#hiddenRemember").val(true);
		}
	})
	$("#remember").change(function(e) {
 		if($("#remember").prop("checked") == true) {
			$("#hiddenRemember").val(true);
		} else {
			$("#hiddenRemember").val(false);
		}
		console.log($("#hiddenRemember").val());
	})
	$("form").submit(function(e) {
		if($("#hiddenRemember").val() == "true") {
			window.localStorage.setItem("rememberedEmail", e.target.email.value);
		} else {
			window.localStorage.removeItem("rememberedEmail");
		}
	})
	$("#login").click(function(e) {
 		if($(this)[0].innerHTML == "Need an account? Register now") {
			window.location.replace("http://localhost:8080/register");
		} else {
			window.location.replace("http://localhost:8080/login");
		}
	})
});