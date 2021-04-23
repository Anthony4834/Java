$(document).ready(function() {
	$(".cloud").hover(function() {
		if($(this).position().left > 650) {
			$(this).stop();
			$(this).animate({left: "-100px"}, 2000, "linear", function() {
				$(this).animate({left: "1400px"}, 300000, "linear");
			})
		}
	});
	$("#cloudImg").animate({left: "1400px"}, 300000, "linear", function() {
		$("#cloudImg").css("left", "-150px");
		$("#cloudImg").animate({left: "1400px"}, 300000, "linear");
	});
	$("#cloudImg2").animate({left: "1400px"}, 210000, "linear", function() {
		$("#cloudImg2").css("left", "-200px");
		$("#cloudImg2").animate({left: "1400px"}, 210000, "linear");
	});
	$("#cloudImg3").animate({left: "1400px"}, 151000, "linear", function() {
		$("#cloudImg3").css("left", "-300px");
		$("#cloudImg3").animate({left: "1400px"}, 151000, "linear");
	});
	$("#cloudImg4").animate({left: "1400px"}, 240000, "linear", function() {
		$("#cloudImg4").css("left", "-600px");
		$("#cloudImg4").animate({left: "1400px"}, 240000, "linear");
	});
	$("#cloudImg5").animate({left: "1400px"}, 300000, "linear", function() {
		$("#cloudImg").css("left", "-150px");
		$("#cloudImg").animate({left: "1400px"}, 300000, "linear");
	});
	$("#err").ready(function() {
			console.log($("#err").text());
			if($('#err').text().length < 1) {
				$('#err').hide();
			}
		});
	$("#logout").click(function(e) {
			window.location.replace("http://localhost:8080/logout");
		})
});